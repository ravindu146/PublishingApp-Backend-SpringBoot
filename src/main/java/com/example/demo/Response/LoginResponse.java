package com.example.demo.Response;

public class LoginResponse {
    String message;
    Boolean status;
    String authToken;
    int userId = -1;
    String name ;
    String email;

    public LoginResponse() {
    }


    public LoginResponse(String message, Boolean status, String authToken, int userId, String name, String email) {
        this.message = message;
        this.status = status;
        this.authToken = authToken;
        this.userId = userId;
        this.name = name;
        this.email = email;

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

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
