//package com.example.HistoryManagement.Config;
//
//
//import com.example.HistoryManagement.Service.HistoryService;
//import com.example.HistoryManagement.Service.HistoryServiceImplementation;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaConsumer {
//
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    HistoryService historyService ;
//    @KafkaListener(topics="findUserId",groupId="group_id")
//    public void consumer(String message) throws Exception  {
//        System.out.println(message);
//        historyService.addHistory(message);
//
//    }
//
//}
