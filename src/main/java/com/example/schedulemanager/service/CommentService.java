package com.example.schedulemanager.service;

import com.example.schedulemanager.dto.CommentResponse;
import com.example.schedulemanager.dto.CreateCommentRequest;
import com.example.schedulemanager.entity.Comment;
import com.example.schedulemanager.entity.Schedule;
import com.example.schedulemanager.exception.CustomException;
import com.example.schedulemanager.repository.CommentRepository;
import com.example.schedulemanager.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.schedulemanager.exception.CustomExceptionCode.COMMENT_LIMIT_EXCEED;
import static com.example.schedulemanager.exception.CustomExceptionCode.SCHEDULE_NOT_FOUND;

@Service
@AllArgsConstructor
public class CommentService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 선택한 일정에 댓글 생성
    @Transactional
    public CommentResponse create(Long scheduleId, CreateCommentRequest request) {
        // 일정 존재 확인
        Schedule schedule = scheduleRepository
                .findById(scheduleId).orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));

        int count = commentRepository.countBySchedule(schedule);
        if (count >= 10) {
            throw new CustomException(COMMENT_LIMIT_EXCEED);
        } else {
            Comment comment = new Comment(
                    request.getContent(),
                    request.getAuthor(),
                    request.getPassword(),
                    schedule
            );
            commentRepository.save(comment);

            return new CommentResponse(comment);
        }
    }
}