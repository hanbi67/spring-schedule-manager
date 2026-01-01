package com.example.schedulemanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    //id, createAt, modifiedAt -> 자동 생성되기 때문에 작성 X
    //입력값 검증 (길이 + 필수값 처리)

    @NotBlank(message = "일정 제목(title)은 필수입니다.")
    @Size(max = 30, message = "일정 제목(title)은 30자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "일정 내용(contents)은 필수입니다.")
    @Size(max = 200, message = "일정 내용(contents)은 200자 이하여야 합니다.")
    private String contents;

    @NotBlank(message = "작성자명(authorName)은 필수입니다.")
    private String authorName;

    @NotBlank(message = "비밀번호(password)는 필수입니다.")
    private String password;
}
