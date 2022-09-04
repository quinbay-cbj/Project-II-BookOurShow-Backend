package com.example.UserMicroServices.status;

import org.springframework.stereotype.Component;

@Component
public class StatusClass {
    private int statusCode;
    private String statusMessage;
    private String role;
    private String userId;
    private String name;

    public StatusClass() {
    }

    public StatusClass(int statusCode, String statusMessage, String role, String userId, String name) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.role = role;
        this.userId = userId;
        this.name = name;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
