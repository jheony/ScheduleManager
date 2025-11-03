package com.example.schedulemanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateResponse {

    Long id;
    String title;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public CreateResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
