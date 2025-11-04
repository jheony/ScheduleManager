package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.CreateRequest;
import com.example.schedulemanager.dto.DeleteRequest;
import com.example.schedulemanager.dto.ScheduleResponse;
import com.example.schedulemanager.dto.UpdateRequest;
import com.example.schedulemanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping("/schedules")
    public ScheduleResponse create(@RequestBody CreateRequest request) {
        return scheduleService.create(request);
    }

    // 일정 전체 조회
    @GetMapping("/schedules")
    public List<ScheduleResponse> getAllSchedule(@RequestParam(required = false) String author) {
        return scheduleService.getAllSchedules(author);
    }

    // 선택 일정 단건 조회
    @GetMapping("/schedules/{id}")
    public ScheduleResponse getOneSchedule(@PathVariable Long id){
        return scheduleService.getOneSchedule(id);
    }

    // 선택 일정 수정
    @PatchMapping("/schedules/{id}")
    public ScheduleResponse updateSchedule(@PathVariable Long id, @RequestBody UpdateRequest request){
        return scheduleService.updateSchedule(id, request);
    }

    // 선택 일정 삭제
    @DeleteMapping("/schedules/{id}")
    public void deleteOneSchedule(@PathVariable Long id, @RequestBody DeleteRequest request){
        scheduleService.deleteOneSchedule(id, request);
    }
}
