package com.lms.exception;

public class UserRequiredFieldException extends RuntimeException {

    public UserRequiredFieldException(){
        super("Required Field");
    }

    public UserRequiredFieldException(String message){
        super(message);
    }
}
