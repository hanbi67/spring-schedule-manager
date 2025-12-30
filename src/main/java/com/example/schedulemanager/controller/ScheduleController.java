package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.CreateScheduleRequest;
import com.example.schedulemanager.dto.CreateScheduleResponse;
import com.example.schedulemanager.dto.GetScheduleResponse;
import com.example.schedulemanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //POST /schedules
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    //GET /schedules/{scheduleId}
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long scheduleId){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    //조회할 작성자명 없다 -> GET /schedules
    //조회할 작성자명 있다 -> GET /schedules?authorName=홍길동
    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(@RequestParam(required = false) String authorName){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll(authorName));
    }


}
