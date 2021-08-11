package com.webapi.catalogfunnelapi.exceptions;

public class FormException extends RuntimeException{

    public FormException(String message) {
        super(message);
    }

    public FormException(String message, Throwable cause) {
        super(message, cause);
    }
}
