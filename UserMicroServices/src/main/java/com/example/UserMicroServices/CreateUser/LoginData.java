package com.example.UserMicroServices.CreateUser;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Id;

@Data
@Configuration
public class LoginData {

    @Id
    private String phoneNumber;
    private String password;

    public LoginData() {
    }

    public LoginData(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
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
