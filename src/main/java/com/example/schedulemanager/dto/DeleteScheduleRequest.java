package com.example.schedulemanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequest {
    //비밀번호만 요청
    //입력값 검증 (길이 + 필수값 처리)
    @NotBlank(message = "비밀번호(password)는 필수입니다.")
    private String password;
}
