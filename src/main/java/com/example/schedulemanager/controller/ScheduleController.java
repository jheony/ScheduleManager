package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.CreateRequest;
import com.example.schedulemanager.dto.CreateResponse;
import com.example.schedulemanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public CreateResponse create(@RequestBody CreateRequest request){
        return scheduleService.create(request);
    }
}
