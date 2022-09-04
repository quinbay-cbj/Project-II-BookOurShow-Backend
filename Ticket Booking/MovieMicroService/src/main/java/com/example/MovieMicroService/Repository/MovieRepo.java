package com.example.MovieMicroService.Repository;

import com.example.MovieMicroService.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepo extends MongoRepository<Movie,String> {

    Movie findByName(String name);

    Movie findByMovieId(String movieId);

    List<Movie> findAllByNameLikeIgnoreCase(String name);


}
