package com.example.UserMicroServices.Service;

import com.example.UserMicroServices.Constant.ConstantClass;
import com.example.UserMicroServices.Constant.ValidateClass;
import com.example.UserMicroServices.CreateUser.LoginData;
import com.example.UserMicroServices.CreateUser.UserData;
import com.example.UserMicroServices.Repository.UserRepository;
import com.example.UserMicroServices.status.StatusClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    StatusClass statusClass;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ValidateClass validateClass;


    @Override
    public StatusClass login(LoginData loginData) {
        UserData userData = userRepository.findByPhoneNumber(loginData.getPhoneNumber());
        if (userData == null) {
            System.out.println("null");
            statusClass.setStatusCode(ConstantClass.NOT_FOUND_CODE);
            statusClass.setStatusMessage(ConstantClass.NO_ACCOUNT_FOUND_MSG);
            statusClass.setName(null);
            statusClass.setRole(null);
            statusClass.setUserId(null);

        } else {
            if (userData.getPassword().equals(loginData.getPassword())) {
                System.out.println("success");
                statusClass.setStatusCode(ConstantClass.SUCCESS_CODE);
                statusClass.setStatusMessage(ConstantClass.SUCCESS_MSG);
                statusClass.setName(userData.getName());
                statusClass.setRole(userData.getRole());
                statusClass.setUserId(userData.getUserId());

            } else {
                System.out.println("not found");
                statusClass.setStatusCode(ConstantClass.NOT_FOUND_CODE);
                statusClass.setStatusMessage(ConstantClass.NOT_FOUND_MSG);
                statusClass.setName(null);
                statusClass.setRole(null);
                statusClass.setUserId(null);
            }
        }
        return statusClass;

    }


}
