package com.example.UserMicroServices.Exception;

public class CustomException extends Exception {

    public CustomException() {
        super("Login Failure");
    }
}
