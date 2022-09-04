package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidDate extends Exception{

    public InvalidDate(){
        super(ConstantClass.INVALID_DATE_MSG);
    }

}