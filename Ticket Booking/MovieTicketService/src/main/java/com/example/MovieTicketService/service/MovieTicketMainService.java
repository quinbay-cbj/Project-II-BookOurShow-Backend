package com.example.MovieTicketService.service;

import com.example.MovieTicketService.model.GetSeatDetails;
import com.example.MovieTicketService.model.MovieDTO;
import com.example.MovieTicketService.model.MovieTicketDTO;

import java.util.List;

public interface MovieTicketMainService {

    String checkAvailability(MovieDTO movieDTO) throws Exception  ;

    String addNewTicketBookings(MovieDTO movieDTO) throws Exception;

    int updateSeatStatus(MovieTicketDTO movieTicketDTO) throws Exception;

    String updateMovie(MovieDTO movieDTO) throws Exception;

    List<MovieTicketDTO> getTicketDetails(GetSeatDetails getSeatDetails) throws Exception;


}
