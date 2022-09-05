package com.example.HistoryManagement.Service;

import com.example.HistoryManagement.Entity.HistoryData;
import com.example.HistoryManagement.Entity.MovieTicket;
import com.example.HistoryManagement.Entity.SeatDetails;
import com.example.HistoryManagement.Exception.CustomException;
import com.example.HistoryManagement.Repository.HistoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HistoryServiceImplementation implements HistoryService {

    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    HistoryData historyData;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    private String message;

    @Override
    public String addHistory(MovieTicket movieTicket) {
        List<Integer> seatNumber = new ArrayList<>();
        int amount = 0;
        String userId = "";
        for (SeatDetails seatD : movieTicket.getSeat()) {
            seatNumber.add(seatD.getSeatNumber());
            amount += seatD.getAmount();
            userId = seatD.getUserId();
        }
        historyData.setHistoryId(UUID.randomUUID().toString());
        historyData.setUserId(userId);
        historyData.setSeats(seatNumber);
        historyData.setDate(movieTicket.getDate());
        historyData.setSlot(movieTicket.getSlot());
        historyData.setMovieName(movieTicket.getName());
        historyData.setTotalAmount(amount);
        historyRepository.save(historyData);
        return "success";
    }

    @KafkaListener(topics="findUserId",groupId="group_id")
    public void consumer(String message) throws Exception  {
        System.out.println(message);
        this.message=message;
    }
    @Override
    public List<HistoryData> getHistory(String userId) throws CustomException {
        try {
            String URI;
            URI = "http://localhost:8081/get/" + userId;
            restTemplate.getForObject(URI, String.class);
            if (message.equalsIgnoreCase("success")) {
                List<HistoryData> user = historyRepository.findAllByUserId(userId);
                return user;
            } else {
                throw new CustomException();
            }
        } catch (Exception e) {
            throw new CustomException();
        }
    }



//    @Override
//    public List<HistoryData> getHistory(String userId) throws CustomException {
//        try {
//            String URI;
//            URI = "http://localhost:8081/get/" + userId;
//            String response = restTemplate.getForObject(URI, String.class);
//            if (response.equalsIgnoreCase("success")) {
//                List<HistoryData> user = historyRepository.findAllByUserId(userId);
//                return user;
//            } else {
//                throw new CustomException();
//            }
//        } catch (Exception e) {
//            throw new CustomException();
//        }
//    }


}
