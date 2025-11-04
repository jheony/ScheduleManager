package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.CommentResponse;
import com.example.schedulemanager.dto.CreateCommentRequest;
import com.example.schedulemanager.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 선택 일정에 댓글 생성
    @PostMapping("/schedules/{scheduleId}/comments")
    public CommentResponse createComment(@PathVariable Long scheduleId,
                                         @RequestBody CreateCommentRequest request){
        return commentService.create(scheduleId, request);
    }
}
