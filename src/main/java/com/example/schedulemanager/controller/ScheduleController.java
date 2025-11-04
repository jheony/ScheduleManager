package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.CreateRequest;
import com.example.schedulemanager.dto.ScheduleResponse;
import com.example.schedulemanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponse create(@RequestBody CreateRequest request) {
        return scheduleService.create(request);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponse> getAllSchedule(@RequestParam(required = false) String author) {
        return scheduleService.getAllSchedules(author);
    }
}
