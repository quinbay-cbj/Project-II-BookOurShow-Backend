package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidGenre extends Exception {

    public InvalidGenre(){
        super(ConstantClass.INVALID_GENRE_MSG);
    }

}