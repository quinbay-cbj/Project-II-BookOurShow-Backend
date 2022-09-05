package com.example.HistoryManagement.Service;

import com.example.HistoryManagement.Entity.HistoryData;
import com.example.HistoryManagement.Entity.MovieTicket;
import com.example.HistoryManagement.Exception.CustomException;

import java.util.List;

public interface HistoryService {
   String addHistory(MovieTicket movieTicket) ;

    List<HistoryData> getHistory(String userId)throws CustomException;

}
