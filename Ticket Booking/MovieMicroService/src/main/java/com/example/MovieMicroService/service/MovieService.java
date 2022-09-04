package com.example.MovieMicroService.service;
import com.example.MovieMicroService.model.MovieDTO;

import java.util.List;

public interface MovieService {

  String addNewMovie(MovieDTO movieDTO) throws Exception;

  MovieDTO getDetails(String movieId) throws Exception;

  List<MovieDTO> getDetailsAllMovies() throws Exception;

  List<MovieDTO> getSpecificMovie(String name) throws Exception;

  String updateMovie(MovieDTO movieDTO) throws Exception;

}
