package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class MovieNotFound extends Exception {

    public MovieNotFound(String movieId)
    {
        super(ConstantClass.MOVIE_NOT_FOUND_MSG +movieId);
    }

}
