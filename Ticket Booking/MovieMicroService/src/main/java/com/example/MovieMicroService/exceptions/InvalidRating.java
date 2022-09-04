package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidRating extends Exception {

    public InvalidRating(){
        super(ConstantClass.INVALID_RATING_MSG);
    }
}