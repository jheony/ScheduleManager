package com.example.schedulemanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCommentRequest {

    @NotBlank(message = "일정 내용은 필수 입력값입니다.")
    @Size(max = 100)
    String content;

    @NotBlank(message = "작성자명은 필수 입력값입니다.")
    String author;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    String password;
}
