package com.example.sessionpractice.service;

import com.example.sessionpractice.domain.User;
import com.example.sessionpractice.repository.UserRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("새로운 유저를 등록한다.")
    @Test
    void save_success() {
        // given
        UserSaveParam param = UserSaveParam.builder()
                .name("아이디1")
                .password("비밀번호1")
                .build();

        // when
        Long savedUserId = userService.save(param);
        Optional<User> foundId = userRepository.findById(savedUserId);

        // then
        Assertions.assertThat(foundId).isPresent();
    }
}
