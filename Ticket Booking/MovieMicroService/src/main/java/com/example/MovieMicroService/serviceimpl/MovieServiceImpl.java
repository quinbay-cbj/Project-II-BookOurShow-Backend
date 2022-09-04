package com.example.MovieMicroService.serviceimpl;

import com.example.MovieMicroService.Repository.MovieRepo;
import com.example.MovieMicroService.entity.Movie;
import com.example.MovieMicroService.exceptions.*;
import com.example.MovieMicroService.helper.ConstantClass;
import com.example.MovieMicroService.helper.ValidationClass;
import com.example.MovieMicroService.model.MovieDTO;
import com.example.MovieMicroService.service.MovieService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepo movieRepo;

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    private RestTemplate restTemplate;

    private  String URI;


    @Override
    public String addNewMovie(MovieDTO movieDTO) throws Exception{


        Movie movieTemp = movieRepo.findByName( movieDTO.getName() );

        if(movieTemp == null) {

            if (!ValidationClass.validateName(movieDTO.getName()))
                throw new InvalidName();

            if (!ValidationClass.validateDuration(movieDTO.getDuration()))
                throw new InvalidDuration();

            if (!ValidationClass.validateGenre(movieDTO.getGenre()))
                throw new InvalidGenre();

            if (!ValidationClass.validateRating(movieDTO.getRating()))
                throw new InvalidRating();

            if (!ValidationClass.validateDescription(movieDTO.getDescription()))
                throw new InvalidDescription();

            if (!ValidationClass.validatePrice(movieDTO.getNormalPrice(), movieDTO.getExecutivePrice()
                    , movieDTO.getPremiumPrice()))
                throw new InvalidPrice();

            if (!ValidationClass.validateDate(movieDTO.getStartDate(), movieDTO.getEndDate()))
                throw new InvalidDate();

            if (!ValidationClass.validateSlots(movieDTO.getSlots()))
                throw new InvalidSlots();

            if (!ValidationClass.validateImageUrl(movieDTO.getImageUrl()))
                throw new InvalidImageUrl();


            movieDTO.setMovieId(UUID.randomUUID().toString());
            URI = UriComponentsBuilder.fromHttpUrl(ConstantClass.CHECK_AVAIL_LINK).encode().toUriString();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<MovieDTO> entity = new HttpEntity<MovieDTO>(movieDTO, httpHeaders);
            String response = restTemplate.exchange(URI, HttpMethod.POST, entity, String.class).getBody();

            if (response.equals(ConstantClass.SLOT_AVAILABLE_MSG)) {
                Movie movie = modelMapper.map(movieDTO, Movie.class);
                movieRepo.save(movie);
            } else return response;


            URI = UriComponentsBuilder.fromHttpUrl(ConstantClass.ADD_TICKET_BLOCK_LINK).encode().toUriString();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<MovieDTO> MovieModelentity = new HttpEntity<MovieDTO>(movieDTO, httpHeaders);
            String responseTwo = restTemplate.exchange(URI, HttpMethod.POST, MovieModelentity, String.class).getBody();
            if (responseTwo.equals(ConstantClass.INSERTED_SUCCESSFULLY_MSG))
                return ConstantClass.returnInsertedSuccess(movieDTO.getName(),movieDTO.getMovieId());
            else return response;
        }
            return ConstantClass.MOVIE_ALREADY_EXIST_MSG;
    }

    @Override
    public MovieDTO getDetails(String movieId) throws Exception {
        Movie movie = movieRepo.findByMovieId(movieId);
        if(movie == null){
            throw new MovieNotFound(movieId);
        }
        else{
           MovieDTO movieDTO = modelMapper.map(movie,MovieDTO.class);
           return movieDTO;
        }
    }

    @Override
    public List<MovieDTO> getDetailsAllMovies() throws Exception{

        List<Movie> movieList = movieRepo.findAll();
        if(movieList.isEmpty()){
            throw new NoRecordsFound();
        }
        else{
                Type listType = new TypeToken<List<MovieDTO>>(){}.getType();
                return modelMapper.map(movieList,listType);
        }
    }

    @Override
    public List<MovieDTO> getSpecificMovie(String name) throws Exception {

        List<Movie> movieList = movieRepo.findAllByNameLikeIgnoreCase(name);
        if(movieList.isEmpty()) throw new MovieNotFound(name);
        else{
            Type listType = new TypeToken<List<MovieDTO>>(){}.getType();
            return modelMapper.map(movieList,listType);
        }
    }

    @Override
    public String updateMovie(MovieDTO movieDTO) throws Exception{

        Movie movie = movieRepo.findByMovieId(movieDTO.getMovieId());
        if( movie == null )
            throw new MovieNotFound(movie.getMovieId());
        if (!ValidationClass.validateName(movieDTO.getName()))
            throw new InvalidName();

        if (!ValidationClass.validateDuration(movieDTO.getDuration()))
            throw new InvalidDuration();

        if (!ValidationClass.validateDescription(movieDTO.getDescription()))
            throw new InvalidDescription();

        if (!ValidationClass.validatePrice(movieDTO.getNormalPrice(), movieDTO.getExecutivePrice()
                , movieDTO.getPremiumPrice()))
            throw new InvalidPrice();

        if (!ValidationClass.validateSlots(movieDTO.getSlots()))
            throw new InvalidSlots();

        if (!ValidationClass.validateImageUrl(movieDTO.getImageUrl()))
            throw new InvalidImageUrl();

        movie.setName( movieDTO.getName() );
        movie.setDuration( movieDTO.getDuration() );
        movie.setNormalPrice( movieDTO.getNormalPrice() );
        movie.setExecutivePrice( movieDTO.getExecutivePrice() );
        movie.setPremiumPrice( movieDTO.getPremiumPrice() );
        movie.setVideoUrl( movieDTO.getVideoUrl() );
        movie.setImageUrl( movieDTO.getImageUrl() );
        movie.setDescription( movieDTO.getDescription() );
        movieRepo.save(movie);


        URI = UriComponentsBuilder.fromHttpUrl(ConstantClass.UPDATE_MOVIE_LINK).encode().toUriString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<MovieDTO> entity = new HttpEntity<MovieDTO>(movieDTO, httpHeaders);
        String response = restTemplate.exchange(URI, HttpMethod.PUT, entity, String.class).getBody();

        return response;

    }


}
