package com.my.demo.exception;

public class PaymentNotFoundException extends AppException{
    public PaymentNotFoundException(String message){
        super(message);
    }
}
