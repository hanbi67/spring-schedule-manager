package com.example.schedulemanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    //id, createAt, modifiedAt -> 자동 생성되기 때문에 작성 X
    //일정 제목, 작성자명만 수정 가능
    //비밀번호 함께 전달
    //입력값 검증 (길이 + 필수값 처리)

    @NotBlank(message = "일정 제목(title)은 필수입니다.")
    @Size(max = 30, message = "일정 제목(title)은 30자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "작성자명(authorName)은 필수입니다.")
    private String authorName;

    @NotBlank(message = "비밀번호(password)는 필수입니다.")
    private String password;
}
