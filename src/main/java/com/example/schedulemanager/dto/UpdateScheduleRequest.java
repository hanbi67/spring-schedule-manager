package com.example.schedulemanager.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    //id, createAt, modifiedAt -> 자동 생성되기 때문에 작성 X
    //일정 제목, 작성자명만 수정 가능
    //비밀번호 함께 전달
    private String title;
    private String authorName;
    private String password;
}
