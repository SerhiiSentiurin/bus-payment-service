package com.my.demo.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String message){
        super(message);
    }
}
