package com.g25.mailer.user.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g25.mailer.user.common.CommonResponse;
import com.g25.mailer.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    // [QUIZ] 아래 에러 수정하기
//    @PostMapping("/user")
//    public CommonResponse<String> signup(AddUserRequest request) {
//        userService.save(request); //로그인 메서드 호출
//        return CommonResponse.success(AddUserResponse.builder()
//                                                     .email(request.getEmail())
//                                                     .build());
//    }

    @GetMapping("/logout")
    public CommonResponse<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request, response, SecurityContextHolder.getContext().getAuthentication()); //핸들러가 logout메서드 호출 & 로그아웃
        return CommonResponse.success();
    }

//    // CREATE: 사용자 등록
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        if (userRepository.existsByLoginId(user.getLoginId()) || userRepository.existsByEmail(
//                user.getEmail())) {
//            return ResponseEntity.badRequest().body(null);
//        }
//        User savedUser = userRepository.save(user);
//        return ResponseEntity.created(URI.create("/api/users/" + savedUser.getId())).body(savedUser);
//    }

//    // READ: 전체 사용자 조회
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return ResponseEntity.ok(users);
//    }
//
//    // READ: 특정 사용자 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        Optional<User> user = userRepository.findById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // UPDATE: 사용자 정보 수정
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        return userRepository.findById(id).map(existingUser -> {
//            existingUser.setName(updatedUser.getName());
//            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setContact(updatedUser.getContact());
//            existingUser.setRole(updatedUser.getRole());
//            existingUser.setStatus(updatedUser.getStatus());
//            User savedUser = userRepository.save(existingUser);
//            return ResponseEntity.ok(savedUser);
//        }).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // DELETE: 사용자 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
