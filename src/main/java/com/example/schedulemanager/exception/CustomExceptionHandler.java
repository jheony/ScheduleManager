package com.example.schedulemanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<CustomExceptionResponse> handleCustomException(CustomException e){
        return CustomExceptionResponse.toResponseEntity(e.getCustomExceptionCode());
    }
}
