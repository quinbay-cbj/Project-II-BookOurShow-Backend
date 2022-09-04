package com.example.UserMicroServices.Service;

import com.example.UserMicroServices.CreateUser.UserData;
import com.example.UserMicroServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImplementation implements HistoryService {
    @Autowired
    UserRepository userRepository;

    @Override
    public String getUserId(String userId) {
        UserData userData = userRepository.findByUserId(userId);
        if (userData == null)
            return "failed";
        else
            return "success";
    }
}
