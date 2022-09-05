package com.example.UserMicroServices.Service;

import com.example.UserMicroServices.CreateUser.LoginData;
import com.example.UserMicroServices.status.StatusClass;

public interface LoginService {
    StatusClass login(LoginData loginData);

}
