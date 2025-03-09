package com.g25.mailer.user.dto;

import com.g25.mailer.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemporarySaveRequest {
    private String userId;
    private String content;
}
