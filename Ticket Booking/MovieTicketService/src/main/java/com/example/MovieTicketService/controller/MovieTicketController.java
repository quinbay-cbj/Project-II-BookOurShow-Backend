package com.example.MovieTicketService.controller;

import com.example.MovieTicketService.helper.ConstantClass;
import com.example.MovieTicketService.model.GetSeatDetails;
import com.example.MovieTicketService.model.MovieDTO;
import com.example.MovieTicketService.model.MovieTicketDTO;
import com.example.MovieTicketService.service.MovieTicketMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(ConstantClass.CROSS_ORGIN)
public class MovieTicketController {


    @Autowired
    MovieTicketMainService movieTicketMainService;

    @PostMapping(ConstantClass.CHECK_AVAIL)
    public String checkAvailability(@RequestBody MovieDTO movieDTO){
       try{
           return movieTicketMainService.checkAvailability(movieDTO);
       }catch (Exception exception){
           return exception.getMessage();
       }
    }


    @PostMapping(ConstantClass.ADD_NEW_TICKET_BLOCK)
    public String addNewTicket(@RequestBody MovieDTO movieDTO){
        try{
           return movieTicketMainService.addNewTicketBookings(movieDTO);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }


    @PutMapping(ConstantClass.UPDATE_SEAT)
    public int updateSeatStatus(@RequestBody MovieTicketDTO movieTicketDTO){
        try{
            return movieTicketMainService.updateSeatStatus(movieTicketDTO);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }


    @PutMapping(ConstantClass.UPDATE)
    public String updateMovie(@RequestBody MovieDTO movieDTO){
        try{
            return movieTicketMainService.updateMovie(movieDTO);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }


    @PutMapping(ConstantClass.GET_SLOT_DETAILS)
    public List<MovieTicketDTO> getSeatDetail(@RequestBody GetSeatDetails getSeatDetails){
        System.out.println(getSeatDetails);
        try{
            return movieTicketMainService.getTicketDetails(getSeatDetails);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }

    }


}
