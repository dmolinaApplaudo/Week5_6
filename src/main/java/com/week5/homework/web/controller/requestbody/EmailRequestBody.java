package com.week5.homework.web.controller.requestbody;

public class EmailRequestBody {
    private String email;

    public EmailRequestBody() {
    }

    public EmailRequestBody(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
