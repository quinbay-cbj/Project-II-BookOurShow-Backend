package com.example.MovieTicketService.repository;
import com.example.MovieTicketService.entity.MovieTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MovieTicketRepo extends MongoRepository<MovieTicket,String> {

     List<MovieTicket> findAllByMovieId(String movieId);

}
