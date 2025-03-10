package com.g25.mailer.user.service;

import com.g25.mailer.user.entity.Template;
import com.g25.mailer.user.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TemplateService {
    private final TemplateRepository templateRepository;

    /**
     * 선택
     */
    public Optional<Template> getTemplate(String target, String keyword1, String keyword2) {
        return templateRepository.findByTargetAndKeyword1AndKeyword2(target, keyword1, keyword2); //아직 다 못함.
    }
}
