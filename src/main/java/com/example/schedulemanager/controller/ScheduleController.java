package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.*;
import com.example.schedulemanager.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping("/schedules")
    public ScheduleResponse create(@Valid @RequestBody CreateScheduleRequest request) {
        return scheduleService.create(request);
    }

    // 일정 전체 조회
    @GetMapping("/schedules")
    public List<ScheduleResponse> getAllSchedule(@RequestParam(required = false) String author) {
        return scheduleService.getAllSchedules(author);
    }

    // 선택 일정 단건 조회
    @GetMapping("/schedules/{id}")
    public ReadOneScheduleResponse getOneSchedule(@PathVariable Long id) {
        return scheduleService.getOneSchedule(id);
    }

    // 선택 일정 수정
    @PatchMapping("/schedules/{id}")
    public ScheduleResponse updateSchedule(@PathVariable Long id, @Valid @RequestBody UpdateScheduleRequest request) {
        return scheduleService.updateSchedule(id, request);
    }

    // 선택 일정 삭제
    @DeleteMapping("/schedules/{id}")
    public ScheduleResponse deleteOneSchedule(@PathVariable Long id, @Valid @RequestBody DeleteScheduleRequest request) {
        return scheduleService.deleteOneSchedule(id, request);
    }
}
