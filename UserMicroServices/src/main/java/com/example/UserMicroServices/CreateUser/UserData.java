package com.example.UserMicroServices.CreateUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Userlogin")
public class UserData {

    @Column(name = "userid")
    private String userId;
    @Column(name = "username")
    private String name;
    @Id
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;


    public UserData() {
    }

    public UserData(String phoneNumber, String userId, String password, String role, String name) {
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
