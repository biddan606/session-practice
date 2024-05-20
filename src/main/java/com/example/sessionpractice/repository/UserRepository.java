package com.example.sessionpractice.repository;

import com.example.sessionpractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
