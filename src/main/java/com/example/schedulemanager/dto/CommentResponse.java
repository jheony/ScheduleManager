package com.example.schedulemanager.dto;

import com.example.schedulemanager.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

    Long id;
    String content;
    String author;
    Long scheduleId;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.author = comment.getAuthor();
        this.scheduleId = comment.getSchedule().getId();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
