package com.example.schedulemanager.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    CustomExceptionCode customExceptionCode;

    public CustomException(CustomExceptionCode customExceptionCode){
        this.customExceptionCode = customExceptionCode;
    }

}
