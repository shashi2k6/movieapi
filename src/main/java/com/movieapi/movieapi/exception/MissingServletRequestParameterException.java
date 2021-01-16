package com.movieapi.movieapi.exception;

public class MissingServletRequestParameterException extends Exception {

    public MissingServletRequestParameterException(String msg) {
        super(msg);
    }
}
