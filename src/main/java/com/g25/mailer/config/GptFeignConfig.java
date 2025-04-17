package com.g25.mailer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Configuration
public class GptFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000); // ms
    }

    //새로 추가(버전변경없이 수정) :  Spring Web의 ClientHttpResponse와 Spring Cloud OpenFeign 내부 디코더 간의 충돌 해결

    @Bean
    public Decoder feignDecoder(ObjectMapper objectMapper) {
        return (response, type) -> {
            // 응답 바디가 비어있으면 null 반환
            if (response.body() == null) {
                return  new RuntimeException("응답 에러: " + response.status());
            }
            //gpt 에러
            if (response.status() >= 400) {
                throw new RuntimeException("OpenAI 에러: " + response.status());
            }

            try (Reader reader = response.body().asReader(StandardCharsets.UTF_8)) {
                return objectMapper.readValue(reader, objectMapper.constructType(type));
            }
        };
    }
}
