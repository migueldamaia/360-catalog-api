package com.webapi.catalogfunnelapi.exceptions;

public class RateException extends RuntimeException{

    public RateException(String message) {
        super(message);
    }

    public RateException(String message, Throwable cause) {
        super(message, cause);
    }
}
