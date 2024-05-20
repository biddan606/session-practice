package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long save(UserSaveParam param) {
        User newUser = User.builder()
                .name(param.name())
                .password(param.password())
                .build();

        User savedUser = userRepository.save(newUser);
        return savedUser.getId();
    }
}
