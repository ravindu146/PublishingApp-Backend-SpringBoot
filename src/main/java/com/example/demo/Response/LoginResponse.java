package com.example.demo.Response;

public class LoginResponse {
    String message;
    Boolean status;
    int userId = -1;

    public LoginResponse() {
    }


    public LoginResponse(String message, Boolean status, int userId) {
        this.message = message;
        this.status = status;
        this.userId = userId;
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
