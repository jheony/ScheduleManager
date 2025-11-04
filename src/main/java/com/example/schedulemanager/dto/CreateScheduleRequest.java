package com.example.schedulemanager.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    String title;
    String content;
    String author;
    String password;
}
