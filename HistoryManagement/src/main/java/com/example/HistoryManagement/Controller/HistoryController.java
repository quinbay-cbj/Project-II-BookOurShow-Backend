package com.example.HistoryManagement.Controller;

import com.example.HistoryManagement.Entity.HistoryData;
import com.example.HistoryManagement.Entity.MovieTicket;
import com.example.HistoryManagement.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin(origins = "*")
public class HistoryController {
    @Autowired
    HistoryService historyService;


    @PostMapping("/add")
    public String addHistoryDetails(@RequestBody MovieTicket movieTicket) {
        try {
            return historyService.addHistory(movieTicket);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @GetMapping("/get/{userId}")
    public List<HistoryData> getHistoryDetails(@PathVariable String userId) {
        try {
            return historyService.getHistory(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

       // return historyService.getHistory(userId);
    }


