package com.g25.mailer.user.dto;

import com.g25.mailer.user.entity.User;
import jakarta.validation.constraints.NotNull;

public class TemporarySaveResponse {

    @NotNull  private String userId;

    public User toEntity(){
        return User.builder()
                .email(userId)
                .build();
    }



}
