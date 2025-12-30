package com.example.schedulemanager.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    //id, createAt, modifiedAt -> 자동 생성되기 때문에 작성 X
    private String title;
    private String contents;
    private String authorName;
    private String password;
}
