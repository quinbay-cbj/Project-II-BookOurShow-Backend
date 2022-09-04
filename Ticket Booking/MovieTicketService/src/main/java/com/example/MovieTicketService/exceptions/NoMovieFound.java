package com.example.MovieTicketService.exceptions;

import com.example.MovieTicketService.helper.ConstantClass;

public class NoMovieFound extends Exception {

    public NoMovieFound(){
        super(ConstantClass.NO_MOVIE_FOUND_MSG);
    }

}
