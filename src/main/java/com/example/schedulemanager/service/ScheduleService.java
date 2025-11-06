package com.example.schedulemanager.service;

import com.example.schedulemanager.dto.*;
import com.example.schedulemanager.entity.Comment;
import com.example.schedulemanager.entity.Schedule;
import com.example.schedulemanager.exception.CustomException;
import com.example.schedulemanager.repository.CommentRepository;
import com.example.schedulemanager.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.schedulemanager.exception.CustomExceptionCode.INVALID_PASSWORD;
import static com.example.schedulemanager.exception.CustomExceptionCode.SCHEDULE_NOT_FOUND;

@Service
@AllArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 일정 생성
    @Transactional
    public ScheduleResponse create(CreateScheduleRequest request) {

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        scheduleRepository.save(schedule);

        return new ScheduleResponse(schedule);
    }

    // 일정 전체 조회
    @Transactional
    public List<ScheduleResponse> getAllSchedules(String author) {

        // 작성자 값이 있으면 필터링 조회 없으면 전체 조회
        List<Schedule> scheduleList = new ArrayList<>(
                (author == null) ? scheduleRepository.findAll() : scheduleRepository.findByAuthor(author));

        // 조회된 Schedule리스트를 response (dto) 리스트로 변환
        List<ScheduleResponse> scheduleResponseList = new ArrayList<>();
        scheduleList.forEach(schedule -> scheduleResponseList.add(
                new ScheduleResponse(schedule)));

        // 수정일 기준 내림차순 정렬
        return scheduleResponseList.stream()
                .sorted((o1, o2) -> o2.getUpdatedAt().compareTo(o1.getUpdatedAt())).toList();
    }

    // 선택 일정 조회
    @Transactional
    public ReadOneScheduleResponse getOneSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));

        // 일정에 등록된 댓글 조회
        List<Comment> comments = new ArrayList<>(commentRepository.findBySchedule(schedule));

        return new ReadOneScheduleResponse(schedule, comments);
    }

    // 선택 일정 수정
    @Transactional
    public ScheduleResponse updateSchedule(Long id, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));

        // 비밀번호 검증 후 일정 수정
        if (schedule.getPassword().equals(request.getPassword())) {
            schedule.setTitle(request.getTitle());
            schedule.setAuthor(request.getAuthor());

            schedule = scheduleRepository.save(schedule);
        } else {
            throw new CustomException(INVALID_PASSWORD);
        }
        return new ScheduleResponse(schedule);
    }

    // 선택 일정 삭제
    @Transactional
    public ScheduleResponse deleteOneSchedule(Long id, DeleteScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));

        // 비밀번호 검증
        if (schedule.getPassword().equals(request.getPassword())) {

            // 해당 일정에 등록된 댓글 먼저 삭제
            commentRepository.deleteBySchedule(schedule);
            // 일정 삭제
            scheduleRepository.deleteById(id);
            return new ScheduleResponse(schedule);
        } else {
            throw new CustomException(INVALID_PASSWORD);
        }
    }
}