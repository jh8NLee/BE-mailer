package com.g25.mailer.draft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemporarySaveRequest {
    @NotNull private String email;
    @NotNull private String content;



}
