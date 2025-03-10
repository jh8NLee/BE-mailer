package com.g25.mailer.user.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    /**
     * 여기에 약관 동의관련내용넣을 예정
     * validation으로 NotNUll 체크시 폼으로 다시 돌려보냄 -> controller에서 @Valided
     */
    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;

    private String city;
    private String street;
    private String zipCode;
}

