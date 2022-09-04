package com.example.MovieMicroService.exceptions;

import com.example.MovieMicroService.helper.ConstantClass;

public class InvalidImageUrl extends Exception {

    public InvalidImageUrl(){
        super(ConstantClass.INVALID_IMAGEURL_MSG);
    }

}
