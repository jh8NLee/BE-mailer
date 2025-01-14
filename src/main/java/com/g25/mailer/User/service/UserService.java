package com.g25.mailer.User.service;

import com.g25.mailer.User.dto.UserCreateReqt;
import com.g25.mailer.User.dto.UserResp;
import com.g25.mailer.User.dto.UserUpdateReqt;
import com.g25.mailer.User.entity.User;
import com.g25.mailer.User.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // CREATE: 사용자 생성
    @Transactional
    public UserResp createUser(UserCreateReqt request) {
        if (userRepository.existsByLoginId(request.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 로그인 ID입니다.");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        User user = User.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword()) // 암호화 필요 시 적용
                .name(request.getName())
                .email(request.getEmail())
                .contact(request.getContact())
                .role(User.Role.USER)
                .status(User.Status.ACTIVE)
                .build();

        User savedUser = userRepository.save(user);
        return UserResp.fromEntity(savedUser);
    }

    // READ: 전체 사용자 조회
    @Transactional(readOnly = true)
    public List<UserResp> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResp::fromEntity)
                .collect(Collectors.toList());
    }

    // READ: 특정 사용자 조회
    @Transactional(readOnly = true)
    public UserResp getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        return UserResp.fromEntity(user);
    }

    // UPDATE: 사용자 정보 수정
    @Transactional
    public UserResp updateUser(Long id, UserUpdateReqt request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        existingUser.setContact(request.getContact());
        existingUser.setRole(request.getRole());
        existingUser.setStatus(request.getStatus());

        User updatedUser = userRepository.save(existingUser);
        return UserResp.fromEntity(updatedUser);
    }

    // DELETE: 사용자 삭제
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        userRepository.deleteById(id);
    }

}
