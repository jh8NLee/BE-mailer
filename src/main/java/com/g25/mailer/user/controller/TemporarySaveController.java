package com.g25.mailer.user.controller;

import com.g25.mailer.user.dto.TemporarySaveRequest;
import com.g25.mailer.user.entity.TemporarySave;
import com.g25.mailer.user.service.TemporarySaveService;
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

    @PostMapping("/write")
    public ResponseEntity<TemporarySave> createTemporarySave(@RequestBody TemporarySaveRequest request) {

        log.info("임시 저장 요청: content = {}", request.getContent());

        TemporarySave temporarySave = TemporarySave.builder()
                .content(request.getContent())
                .build();

        TemporarySave saved = temporarySaveService.saveTemporary(temporarySave);
        return ResponseEntity.ok(saved);
    }

    // [API] 단일 임시저장 조회
    @GetMapping("/show/{id}")
    public ResponseEntity<TemporarySave> getTemporarySave(@PathVariable Long id) {
        TemporarySave temporarySave = temporarySaveService.getTemporarySave(id);
        return ResponseEntity.ok(temporarySave);
    }

    // [API] 임시저장 목록 조회 (사용자 인증 제거)
    @GetMapping("/list")
    public ResponseEntity<List<TemporarySave>> listTemporarySaves() {
        List<TemporarySave> saves = temporarySaveService.listTemporarySaves();
        return ResponseEntity.ok(saves);
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
