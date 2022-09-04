package com.example.UserMicroServices.Service;

import com.example.UserMicroServices.Constant.ConstantClass;
import com.example.UserMicroServices.Constant.ValidateClass;
import com.example.UserMicroServices.CreateUser.UserData;
import com.example.UserMicroServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterServiceImplementation implements RegisterService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ValidateClass validateClass;


    @Override
    public String register(UserData userData) {
        if (userRepository.findByPhoneNumber(userData.getPhoneNumber()) == null) {
            if (validateClass.validateName(userData.getName())
                    && validateClass.validateContact(userData.getPhoneNumber()) &&
                    validateClass.validatePassword(userData.getPassword())) {
                userData.setUserId(UUID.randomUUID().toString());
                userData.setRole(ConstantClass.ROLE_USER);
                userRepository.save(userData);
                return "Succesfully Register";
            }
        }
        return "Give Validate Data";

    }


}
