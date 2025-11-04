package com.example.schedulemanager.dto;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    String content;
    String author;
    String password;
}
