package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidPrice extends Exception{

    public InvalidPrice(){
        super(ConstantClass.INVALID_PRICE_MSG);
    }

}

