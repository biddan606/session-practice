package com.example.sessionpractice.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.sessionpractice.controller.form.UserRegisterForm;
import com.example.sessionpractice.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @DisplayName("유저 회원가입")
    @Test
    void register_success() throws Exception {
        // given
        UserRegisterForm form = UserRegisterForm.builder()
                .name("아이디1")
                .password("비밀번호1")
                .build();

        given(userService.save(form.toParam()))
                .willReturn(1L);

        // expected
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", form.getName())
                        .param("password", form.getPassword())
                ).andExpect(status().isOk())
                .andExpect(view().name("/register"));
    }
}
