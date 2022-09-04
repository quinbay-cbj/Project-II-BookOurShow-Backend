package com.example.MovieMicroService.exceptions;


import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidDescription extends Exception {

    public InvalidDescription(){
        super(ConstantClass.INVALID_DESCRIPTION_MSG);
    }
}