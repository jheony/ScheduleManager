package com.example.schedulemanager.service;

import com.example.schedulemanager.dto.CreateRequest;
import com.example.schedulemanager.dto.ScheduleResponse;
import com.example.schedulemanager.entity.Schedule;
import com.example.schedulemanager.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Transactional
    public ScheduleResponse create(CreateRequest request) {

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        scheduleRepository.save(schedule);

        return new ScheduleResponse( schedule);
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
    public ScheduleResponse getOneSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalStateException("없는 유저입니다."));
        return new ScheduleResponse(schedule);
    }
}
