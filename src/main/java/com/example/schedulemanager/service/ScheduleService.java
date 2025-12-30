package com.example.schedulemanager.service;

import com.example.schedulemanager.dto.*;
import com.example.schedulemanager.entity.Schedule;
import com.example.schedulemanager.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContents(),
                request.getAuthorName(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getAuthorName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    //선택 일정 조회(고유 식별자 ID 사용)
    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getAuthorName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    //전체 일정 조회(authorName 기준 조회, modifiedAt DESC)
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll(@Nullable String authorName) {
        //수정일 내림차순 정렬
        Sort sort = Sort.by(Sort.Direction.DESC, "modifiedAt");

        List<Schedule> scheduleList;

        //작성자명이 포함되지 않을 경우 -> 전체 일정 조회 + 수정일 내림차순 정렬
        if (authorName == null || authorName.isBlank()) {
            scheduleList = scheduleRepository.findAll(sort);
        }
        //작성자명이 포함될 경우 -> 작성자명 기준 전체 일정 조회 + 수정일 내림차순 정렬
        else {
            scheduleList = scheduleRepository.findByAuthorName(authorName, sort);
        }

        List<GetScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            dtos.add(new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getAuthorName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            ));
        }
        return dtos;

    }

    //일정 수정
    //비밀번호 검증 로직 추가
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        //비밀번호가 일치하지 않을 경우
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        //비밀번호가 일치할 경우 일정 수정 가능
        schedule.update(request.getTitle(), request.getAuthorName());

        //flush 시점에 @LastModifiedDate가 반영되는 케이스가 많아서,
        //Response 만들기 전에 flush로 강제 반영
        scheduleRepository.flush();

        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getAuthorName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );

    }
}
