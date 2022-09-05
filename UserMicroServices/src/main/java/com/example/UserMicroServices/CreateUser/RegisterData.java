package com.example.UserMicroServices.CreateUser;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Data
@Component
public class RegisterData {
    private String userName;
    @Id
    private String phoneNumber;
    private String password;

    public RegisterData() {
    }

    public RegisterData(String userName, String phoneNumber, String password) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
