package com.saucedemo.exceptions;

public class PriceFormatException extends RuntimeException{
    public PriceFormatException(String message){
        super(message);
    }

    public PriceFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
