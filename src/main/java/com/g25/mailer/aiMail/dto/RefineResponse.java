package com.g25.mailer.aiMail.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RefineResponse {
    private String refined;


    public RefineResponse(String refined) {
        this.refined = refined;
    }
    public String getRefined() {
        return refined;
    }
}
