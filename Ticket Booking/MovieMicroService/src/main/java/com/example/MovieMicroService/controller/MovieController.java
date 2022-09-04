package com.example.MovieMicroService.controller;

import com.example.MovieMicroService.helper.ConstantClass;
import com.example.MovieMicroService.model.MovieDTO;
import com.example.MovieMicroService.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(ConstantClass.CROSS_ORGIN)
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping(ConstantClass.ADD_MOVIE)
    public String addNewMovie(@RequestBody MovieDTO movieDTO){
       try{
          return movieService.addNewMovie(movieDTO);
       }catch (Exception e){
         throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
       }
    }

    @GetMapping(ConstantClass.GET_MOVIE_DETAILS)
    public MovieDTO getDetails(@PathVariable String movieId){
        try{
           return movieService.getDetails(movieId);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }

    @GetMapping(ConstantClass.MOVIES)
    public List<MovieDTO> getDetailsAllMovies(){
        try{
            return movieService.getDetailsAllMovies();
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }

    @GetMapping(ConstantClass.MOVIE_BY_NAME)
    public List<MovieDTO> getSpecificMovie(@PathVariable String name){
        try{
            return movieService.getSpecificMovie(name);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }


    @PutMapping(ConstantClass.UPDATE)
    public String updateMovie(@RequestBody MovieDTO movieDTO){
        try{
            return movieService.updateMovie(movieDTO);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
        }
    }


}
