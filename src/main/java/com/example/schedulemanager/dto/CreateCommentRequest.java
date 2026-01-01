package com.example.schedulemanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCommentRequest {
    //입력값 검증 (길이 + 필수값 처리)

    @NotBlank(message = "댓글 내용(contents)은 필수입니다.")
    @Size(max = 100, message = "댓글 내용(contents)은 100자 이하여야 합니다.")
    private String contents;

    @NotBlank(message = "작성자명(authorName)은 필수입니다.")
    private String authorName;

    @NotBlank(message = "비밀번호(password)는 필수입니다.")
    private String password;
}
