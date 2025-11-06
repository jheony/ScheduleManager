package com.example.schedulemanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomExceptionCode {
    SCHEDULE_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 일정입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    COMMENT_LIMIT_EXCEED(HttpStatus.BAD_REQUEST, "하나의 일정에는 최대 10개의 댓글을 등록할 수 있습니다.");


    private final HttpStatus httpStatus;
    private final String message;
    }
