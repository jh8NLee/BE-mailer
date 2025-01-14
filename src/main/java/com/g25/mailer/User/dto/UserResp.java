package com.g25.mailer.User.dto;

import com.g25.mailer.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResp {
    private Long id;
    private String loginId;
    private String name;
    private String email; 
    private String contact;
    private User.Role role;
    private User.Status status;

    public static UserResp fromEntity(User user) {
        return UserResp.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .name(user.getName())
                .email(user.getEmail())
                .contact(user.getContact())
                .role(user.getRole())
                .status(user.getStatus())
                .build();
    }

}
