package com.example.sessionpractice.service;

import lombok.Builder;

@Builder
public record UserSaveParam(
        String name,
        String password
) {

}
