package com.example.MovieTicketService.serviceimpl;


import com.example.MovieTicketService.entity.MovieTicket;
import com.example.MovieTicketService.entity.SeatDetails;
import com.example.MovieTicketService.exceptions.MovieAlreadyFound;
import com.example.MovieTicketService.exceptions.NoMovieFound;
import com.example.MovieTicketService.helper.ConstantClass;
import com.example.MovieTicketService.model.GetSeatDetails;
import com.example.MovieTicketService.model.MovieDTO;
import com.example.MovieTicketService.model.MovieTicketDTO;
import com.example.MovieTicketService.model.SeatDetailsDTO;
import com.example.MovieTicketService.repository.MovieTicketRepo;
import com.example.MovieTicketService.service.MovieTicketMainService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class MovieTicketServiceImpl implements MovieTicketMainService {


    @Autowired
    MovieTicketRepo movieTicketRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MovieTicket movieTicket;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public String checkAvailability(MovieDTO movieDTO) throws Exception {

        LocalDate start = LocalDate.parse(movieDTO.getStartDate());
        LocalDate end = LocalDate.parse(movieDTO.getEndDate());
        while (!start.isAfter(end)) {
            for(String slot : movieDTO.getSlots()){
                Query query = new Query();
                query.addCriteria(Criteria.where(ConstantClass.DATE).is(start.toString())
                        .and(ConstantClass.SLOT).is(slot));
                List<MovieTicket> movieTicket = mongoTemplate.find(query,MovieTicket.class);
                if(!movieTicket.isEmpty())
                    throw new  MovieAlreadyFound(movieTicket.get(0).getName(), start.toString(),slot);
            }
            start = start.plusDays(1);
        }return ConstantClass.SLOT_AVAILABLE_MSG;

    }


    @Override
    public String addNewTicketBookings(MovieDTO movieDTO) throws Exception {


        String startDate = movieDTO.getStartDate();
        String endDate = movieDTO.getEndDate();
        LocalDate start = LocalDate.parse( startDate );
        LocalDate end = LocalDate.parse( endDate );
        while (!start.isAfter(end)) {
            for(String slot : movieDTO.getSlots()){
              movieTicket.setSlotId(UUID.randomUUID().toString());
              movieTicket.setDate(start.toString());
              movieTicket.setMovieId( movieDTO.getMovieId() );
              movieTicket.setName( movieDTO.getName() );
              movieTicket.setSlot( slot );
              movieTicket.setSeat( new ArrayList<SeatDetails>());
              movieTicketRepo.save( movieTicket );
            }
            start = start.plusDays(1);
        }
        return ConstantClass.INSERTED_SUCCESSFULLY_MSG;
    }


    @Override
    public int updateSeatStatus(MovieTicketDTO movieTicketDTO) throws Exception {


        String URI = UriComponentsBuilder.fromHttpUrl(ConstantClass.ADD_HISTORY_URL).encode().toUriString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<MovieTicketDTO> entity = new HttpEntity<MovieTicketDTO>(movieTicketDTO, httpHeaders);
        String response = restTemplate.exchange(URI, HttpMethod.POST, entity, String.class).getBody();
        if(!response.equals(ConstantClass.SUCCESS_MSG))
            throw new Exception(ConstantClass.HISTORY_MNG_ERROR_MSG);

        int totalAmount = ConstantClass.DEFAULT_AMOUNT_VALUE;

        Query query = new Query();
        query.addCriteria(Criteria.where(ConstantClass.NAME).is(movieTicketDTO.getName())
                .and(ConstantClass.DATE).is(movieTicketDTO.getDate())
                .and(ConstantClass.SLOT).is(movieTicketDTO.getSlot()));
        List<MovieTicket> movieTicketList = mongoTemplate.find(query,MovieTicket.class);



        MovieTicket movieTicket = modelMapper.map(movieTicketDTO,MovieTicket.class);
        List<SeatDetails> seats = movieTicketList.get(0).getSeat();
        for(SeatDetailsDTO seatDetailsDTO : movieTicketDTO.getSeat()){
            SeatDetails seatDetails = modelMapper.map(seatDetailsDTO,SeatDetails.class);
            totalAmount += seatDetails.getAmount();
            seats.add(seatDetails);
        }
        movieTicket.setSlotId( movieTicketDTO.getSlotId() );
        movieTicket.setSeat( seats );

        movieTicketRepo.save(movieTicket);
        return totalAmount;

    }


    @Override
    public String updateMovie(MovieDTO movieDTO) throws Exception {

        List<MovieTicket> movieTickets = movieTicketRepo.findAllByMovieId( movieDTO.getMovieId() );
        if(movieTickets.isEmpty())
            throw new NoMovieFound();

        for( MovieTicket movieTicket : movieTickets ){
            movieTicket.setName( movieDTO.getName() );
            movieTicketRepo.save( movieTicket );
        }
        return ConstantClass.UPDATED_SUCCESSFULLY_MSG;

    }

    @Override
    public List<MovieTicketDTO> getTicketDetails(GetSeatDetails getSeatDetails) throws Exception{
        Query query = new Query();
        query.addCriteria(Criteria.where(ConstantClass.NAME).is(getSeatDetails.getName())
                .and(ConstantClass.DATE).is(getSeatDetails.getDate())
                .and(ConstantClass.SLOT).is(getSeatDetails.getSlot()) );

        List<MovieTicket> movieTicketList = mongoTemplate.find(query,MovieTicket.class);
        if(movieTicketList.isEmpty()) throw new NoMovieFound();
        Type listType = new TypeToken<List<MovieTicketDTO>>(){}.getType();
        return modelMapper.map(movieTicketList,listType);

    }


}
