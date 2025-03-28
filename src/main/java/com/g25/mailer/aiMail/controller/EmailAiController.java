package com.g25.mailer.aiMail.controller;

import com.g25.mailer.aiMail.dto.AutoGenerateRequest;
import com.g25.mailer.aiMail.dto.AutoGenerateResponse;
import com.g25.mailer.aiMail.dto.RefineRequest;
import com.g25.mailer.aiMail.dto.RefineResponse;
import com.g25.mailer.aiMail.service.EmailAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ai")
@RequiredArgsConstructor
public class EmailAiController {

    private final EmailAiService  emailAiService;

    @PostMapping("/generate")
    public ResponseEntity<AutoGenerateResponse> generateEmail(@RequestBody AutoGenerateRequest request) {
        String content = emailAiService.generateEmailContent(request.getPrompt());
        return ResponseEntity.ok(new AutoGenerateResponse(content));
    }

    @PostMapping("/refine")
    public ResponseEntity<RefineResponse> refineEmail(@RequestBody RefineRequest request) {
        String refined = emailAiService.refineEmailContent(request.getContent());
        return ResponseEntity.ok(new RefineResponse(refined));
    }

}
