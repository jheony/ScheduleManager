package com.example.schedulemanager.service;

import com.example.schedulemanager.dto.CreateRequest;
import com.example.schedulemanager.dto.CreateResponse;
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
    public CreateResponse create(CreateRequest request) {

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        scheduleRepository.save(schedule);

        return new CreateResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }

    //
    @Transactional
    public List<ScheduleResponse> getAllByAuthor(String author) {

        List<Schedule> scheduleList = new ArrayList<>(
                (author == null) ? scheduleRepository.findAll() : scheduleRepository.findByAuthor(author));

        List<ScheduleResponse> scheduleResponseList = new ArrayList<>();
        scheduleList.forEach(schedule -> scheduleResponseList.add(
                new ScheduleResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getAuthor(),
                        schedule.getCreatedAt(),
                        schedule.getUpdatedAt()
                )));

        // 수정일 기준 내림차순 정렬
        return scheduleResponseList.stream()
                .sorted((o1, o2) -> o2.getUpdatedAt().compareTo(o1.getUpdatedAt())).toList();
    }
}
