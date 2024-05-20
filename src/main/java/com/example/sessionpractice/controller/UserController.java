package com.example.sessionpractice.controller;

import com.example.sessionpractice.controller.form.UserRegisterForm;
import com.example.sessionpractice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        UserRegisterForm emptyForm = UserRegisterForm.builder().build();
        model.addAttribute("userRegisterForm", emptyForm);

        return "/register";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute UserRegisterForm userRegisterForm,
            BindingResult bindingResult) {
        log.info("form: {}", userRegisterForm);
        if (bindingResult.hasErrors()) {
            log.info("오류 발생: {}", bindingResult.getAllErrors());
            return "/register";
        }

        userService.save(userRegisterForm.toParam());
        return "/register";
    }
}
