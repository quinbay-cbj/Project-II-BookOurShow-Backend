package com.example.HistoryManagement.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Document("historyManagement")
public class HistoryData {
    @Id
    private String historyId;
    private String userId;
    private List<Integer> seats;
    private String date;
    private String slot;
    private String movieName;
    private int totalAmount;

    public HistoryData() {
    }

    public HistoryData(String historyId, String userId, List<Integer> seats, String date, String slot, String movieName, int totalAmount) {
        this.historyId = historyId;
        this.userId = userId;
        this.seats = seats;
        this.date = date;
        this.slot = slot;
        this.movieName = movieName;
        this.totalAmount = totalAmount;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "historyId='" + historyId + '\'' +
                ", userId='" + userId + '\'' +
                ", seats=" + seats +
                ", date='" + date + '\'' +
                ", slot='" + slot + '\'' +
                ", movieName='" + movieName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
