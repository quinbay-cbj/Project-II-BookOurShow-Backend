package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidSlots extends Exception {

    public InvalidSlots(){
        super(ConstantClass.INVALID_SLOTS_MSG);
    }

}
