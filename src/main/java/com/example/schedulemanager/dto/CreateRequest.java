package com.example.schedulemanager.dto;

import lombok.Getter;

@Getter
public class CreateRequest {

    String title;
    String content;
    String author;
    String password;
}
