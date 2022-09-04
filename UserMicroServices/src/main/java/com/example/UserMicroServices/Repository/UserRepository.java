package com.example.UserMicroServices.Repository;

import com.example.UserMicroServices.CreateUser.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {
    UserData findByPhoneNumber(String phoneNumber);

    UserData findByUserId(String userId);
}

