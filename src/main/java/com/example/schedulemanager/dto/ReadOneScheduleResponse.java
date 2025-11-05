package com.example.schedulemanager.dto;

import com.example.schedulemanager.entity.Comment;
import com.example.schedulemanager.entity.Schedule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ReadOneScheduleResponse extends ScheduleResponse {

    List<CommentResponse> comments = new ArrayList<>();

    public ReadOneScheduleResponse(Schedule schedule, List<Comment> comments) {
        super(schedule);
        comments.forEach(comment -> this.comments.add(
                new CommentResponse(comment)
        ));
    }

}
