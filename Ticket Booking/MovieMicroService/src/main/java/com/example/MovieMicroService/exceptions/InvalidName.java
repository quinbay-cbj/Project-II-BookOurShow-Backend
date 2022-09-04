package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidName extends Exception {

    public InvalidName(){
        super(ConstantClass.INVALID_NAME_MSG);
    }

}
