package com.lms.exception;

public class LoanNotFoundException extends RuntimeException{

    public LoanNotFoundException(){
        super("Loan Not Found");
    }

    public LoanNotFoundException(String message){
        super(message);
    }
}
