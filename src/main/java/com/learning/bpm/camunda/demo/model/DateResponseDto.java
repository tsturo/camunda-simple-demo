package com.learning.bpm.camunda.demo.model;

public class DateResponseDto {

    private boolean response;
    private String message;

    public DateResponseDto(boolean response, String message) {
        this.response = response;
        this.message = message;
    }

    public DateResponseDto() {
    }

    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
