package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class NoRecordsFound extends Exception {

    public NoRecordsFound(){
        super(ConstantClass.NO_RECORD_MSG);
    }

}