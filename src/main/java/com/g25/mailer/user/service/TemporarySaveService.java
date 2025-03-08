package com.g25.mailer.user.service;

import com.g25.mailer.user.entity.TemporarySave;
import com.g25.mailer.user.entity.User;
import com.g25.mailer.user.repository.TemporarySaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class TemporarySaveService {


    private final TemporarySaveRepository temporarySaveRepository;

    // 임시저장 생성/저장
    public TemporarySave saveTemporary(TemporarySave temporarySave) {
        temporarySave.setSavedAt(LocalDateTime.now());
        return temporarySaveRepository.save(temporarySave);
    }

    // id로 단일 임시저장 조회
    @Transactional(readOnly = true)
    public TemporarySave getTemporarySave(Long id) {
        return temporarySaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 임시저장 데이터가 존재하지 않습니다."));
    }

    // 모든 임시저장 목록 조회
    @Transactional(readOnly = true)
    public List<TemporarySave> listTemporarySaves() {
        return temporarySaveRepository.findAll();
    }

    // 모든 임시저장 삭제
    public void deleteAllTemporarySaves() {
        temporarySaveRepository.deleteAll();
    }

    // 단일 임시저장 삭제
    public void deleteSingleTemp(Long id) {
        temporarySaveRepository.deleteById(id);
    }
}
