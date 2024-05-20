package com.example.sessionpractice.controller.form;

import com.example.sessionpractice.service.UserSaveParam;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserRegisterForm {

    @NotBlank(message = "유저의 아이디가 비어있습니다.")
    private String name;

    @NotBlank(message = "유저의 비밀번호가 비어있습니다.")
    private String password;

    @Builder
    public UserRegisterForm(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserSaveParam toParam() {
        return UserSaveParam.builder()
                .name(name)
                .password(password)
                .build();
    }
}
