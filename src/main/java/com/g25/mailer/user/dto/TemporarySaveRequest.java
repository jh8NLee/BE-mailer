package com.g25.mailer.user.dto;

import com.g25.mailer.user.entity.TemporarySave;
import com.g25.mailer.user.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemporarySaveRequest {
    @NotNull private String email;
    @NotNull private String content;



}
