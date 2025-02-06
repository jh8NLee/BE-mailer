package com.g25.mailer.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;

    public AddUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
