package com.g25.mailer.User.dto;

import com.g25.mailer.User.entity.User;

public class UserSessionRes {
    private String loginId;
    private String name;
    private User.Role role;

    public UserSessionRes(String loginId, String name, User.Role role) {
        this.loginId = loginId;
        this.name = name;
        this.role = role;
    }

}
