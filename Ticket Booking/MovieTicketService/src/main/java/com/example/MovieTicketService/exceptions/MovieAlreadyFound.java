package com.example.MovieTicketService.exceptions;

public class MovieAlreadyFound extends Exception{

    public MovieAlreadyFound(String name,String start,String slot){
        super(name+" is already in date : "+start+" and slot : "+slot);
    }

}
