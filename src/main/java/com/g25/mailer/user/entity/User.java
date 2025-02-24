package com.g25.mailer.user.entity;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users", indexes = {
        @Index(name = "email_idx", columnList = "email")
}) //이메일로 인덱스걸기
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    // email 컬럼에 Index 설정
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;


    // 추가된 테마 설정 필드 (기본값은 LIGHT)
    @Column(name = "theme", nullable = false)
    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Builder
    public User(String email, String password, Theme theme) {
        this.email = email;
        this.password = password;
        // theme 값이 null일 경우 기본값으로 LIGHT 설정
        this.theme = theme != null ? theme : Theme.LIGHT;
    }


    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }

    //권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    //계정 만료 여부
    @Override
    public String getPassword() {
        return password;
    }

    // 계정 잠김 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        return true;
    }


    // 테마 설정에 사용할 enum
    public enum Theme {
        LIGHT,
        DARK
    }

}


