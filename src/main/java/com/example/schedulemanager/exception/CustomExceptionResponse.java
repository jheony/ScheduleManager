package com.example.schedulemanager.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class CustomExceptionResponse {
    private int status;
    private String name;
    private String message;

    public static ResponseEntity<CustomExceptionResponse> toResponseEntity(CustomExceptionCode e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(CustomExceptionResponse.builder()
                        .status(e.getHttpStatus().value())
                        .name(e.name())
                        .message(e.getMessage())
                        .build());
    }
}