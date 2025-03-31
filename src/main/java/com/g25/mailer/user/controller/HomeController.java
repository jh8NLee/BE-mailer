package com.g25.mailer.user.controller;

import com.g25.mailer.common.CommonResponse;
import com.g25.mailer.user.dto.UserProfileResponse;
import com.g25.mailer.user.entity.User;
import com.g25.mailer.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    @Value("${instance.name}")
    private String instanceName;

    @GetMapping("/")
    public String home() {
        return " __        __   _                            _          __  __       _ _           _ \n" +
                " \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___   |  \\/  | __ _(_) | ___ _ __| |\n" +
                "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |\\/| |/ _` | | |/ _ \\ '__| |\n" +
                "   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |  | | (_| | | |  __/ |  |_|\n" +
                "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_|  |_|\\__,_|_|_|\\___|_|  (_)\n" +
                "                                                                                     "
                + "Response from " + instanceName;
    }

    /**
     * 유저 이미지, 닉네임(이름) 받아오기
     * @param session
     * @return
     */
    @GetMapping("/profile")
    public ResponseEntity<CommonResponse<UserProfileResponse>> getUserProfile(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        //로그인 안된 경우
        if (userId == null) {
            return ResponseEntity.badRequest().body(
                    CommonResponse.fail(new UserProfileResponse("로그인이 필요합니다.", null))
            );
        }

        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    CommonResponse.fail(new UserProfileResponse("유저를 찾을 수 없습니다.", null))
            );
        }

        User user = userOpt.get();
        UserProfileResponse response = new UserProfileResponse(user.getNickname(), user.getProfileImageUrl());

        return ResponseEntity.ok(CommonResponse.success(response));
    }



}
