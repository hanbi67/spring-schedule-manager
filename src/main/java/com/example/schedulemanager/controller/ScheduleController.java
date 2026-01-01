package com.example.schedulemanager.controller;

import com.example.schedulemanager.dto.*;
import com.example.schedulemanager.service.ScheduleService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CreateScheduleResponse> createSchedule(@Valid @RequestBody CreateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    //GET /schedules/{scheduleId}
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleOneResponse> getOne(@PathVariable Long scheduleId){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    //조회할 작성자명 없다 -> GET /schedules
    //조회할 작성자명 있다 -> GET /schedules?authorName=홍길동
    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(@RequestParam(required = false) String authorName){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll(authorName));
    }

    //PUT /schedules/{scheduleId}
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @Valid @RequestBody UpdateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }

    //DELETE /schedules/{scheduleId}
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long scheduleId,
            @Valid @RequestBody DeleteScheduleRequest request){
        scheduleService.delete(scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //댓글 생성
    //POST /schedules/{scheduleId}/comments
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(
            @PathVariable Long scheduleId,
            @Valid @RequestBody CreateCommentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createComment(scheduleId, request));
    }


}
