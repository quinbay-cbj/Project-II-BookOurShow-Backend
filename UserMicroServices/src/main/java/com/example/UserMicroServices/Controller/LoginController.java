package com.example.UserMicroServices.Controller;

import com.example.UserMicroServices.Constant.ConstantClass;
import com.example.UserMicroServices.CreateUser.LoginData;
import com.example.UserMicroServices.CreateUser.UserData;
import com.example.UserMicroServices.Service.HistoryService;
import com.example.UserMicroServices.Service.LoginService;
import com.example.UserMicroServices.Service.RegisterService;
import com.example.UserMicroServices.status.StatusClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    RegisterService registerService;
    @Autowired
    HistoryService historyService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    String kafkaMessage;

    @PostMapping("/login")
    public StatusClass loginPage(@RequestBody LoginData loginData) {

        return loginService.login(loginData);
    }

    @PostMapping("/register")
    public String registerPage(@RequestBody UserData userData) {
        return registerService.register(userData);
    }

    @GetMapping("/get/{userId}")
    public void getUserIdDetails(@PathVariable String userId) {
        kafkaMessage= historyService.getUserId(userId);
        kafkaTemplate.send(ConstantClass.TOPIC,kafkaMessage);
        //return historyService.getUserId(userId);
    }


}
