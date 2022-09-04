package com.example.MovieMicroService.exceptions;


import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidDuration extends Exception {

    public InvalidDuration(){
        super(ConstantClass.INVALID_DURATION_MSG);
    }

}