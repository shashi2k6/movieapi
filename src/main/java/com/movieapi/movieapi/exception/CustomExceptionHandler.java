package com.movieapi.movieapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<String> handleNotFound(GenericNotFoundException genericNotFoundException) {
        return new ResponseEntity<>(genericNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
