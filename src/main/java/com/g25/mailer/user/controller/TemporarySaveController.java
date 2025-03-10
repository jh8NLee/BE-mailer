package com.g25.mailer.user.controller;

import com.g25.mailer.user.dto.TemporarySaveRequest;
import com.g25.mailer.user.dto.TemporarySaveResponse;
import com.g25.mailer.user.entity.TemporarySave;
import com.g25.mailer.user.entity.User;
import com.g25.mailer.user.service.TemporarySaveService;
import com.g25.mailer.user.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporary-saves")
@RequiredArgsConstructor
@Slf4j
public class TemporarySaveController {

    private final TemporarySaveService temporarySaveService;
    private final UserDetailService userService;

    @PostMapping("/write")
    public ResponseEntity<TemporarySave> createTemporarySave(@RequestBody TemporarySaveRequest request) {
        log.info("임시 저장 content = {}", request.getContent());

        User user = userService.getUserByEmail(request.getEmail());

        //생성확인용
        if (user == null) {
            log.error("User 객체를 찾을 수 없습니다. email: {}", request.getEmail());
            return ResponseEntity.badRequest().build();
        }else {
            log.info("유저생성완료");
        }

        TemporarySave temporarySave = TemporarySave.builder()
                .content(request.getContent())
                .user(user)
                .build();

        //생성확인용
        if (temporarySave == null) {
            log.error("TemporarySave 객체 생성 실패!");
            return ResponseEntity.badRequest().build();
        }
        TemporarySave saved = temporarySaveService.saveTemporary(temporarySave);

        return ResponseEntity.ok(saved);
    }


    // [API] 목록 조회 (사용자 인증 제거는 미구현)
    @GetMapping("/list")
    public ResponseEntity<List<TemporarySaveResponse>> listTemporarySaves() {
        List<TemporarySave> saves = temporarySaveService.listTemporarySaves();
        List<TemporarySaveResponse> response = saves.stream()
                .map(TemporarySaveResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    // [API] 임시저장 목록 전체 삭제 (사용자 인증 제거)
    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAllTemp() {
        temporarySaveService.deleteAllTemporarySaves();
        log.info("전체 삭제 완료");
        return ResponseEntity.noContent().build();
    }

    // [API] 임시저장 목록 단건 삭제 (사용자 인증 제거)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSingleTemp(@PathVariable Long id) {
        temporarySaveService.deleteSingleTemp(id);
        log.info("단건 삭제 완료 : ID = {}", id);
        return ResponseEntity.noContent().build();
    }

}
