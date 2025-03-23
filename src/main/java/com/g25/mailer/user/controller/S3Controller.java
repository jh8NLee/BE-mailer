package com.g25.mailer.user.controller;

import com.g25.mailer.user.service.S3Service;
import com.g25.mailer.user.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class S3Controller {

    private final S3Service s3Service;





}
