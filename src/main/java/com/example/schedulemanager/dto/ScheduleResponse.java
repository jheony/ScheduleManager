package com.example.schedulemanager.dto;

import com.example.schedulemanager.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {

    Long id;
    String title;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public ScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public ScheduleResponse(Schedule schedule){

        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();

    }
}
