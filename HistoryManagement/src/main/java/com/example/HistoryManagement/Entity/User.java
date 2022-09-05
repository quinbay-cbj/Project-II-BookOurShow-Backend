package com.example.HistoryManagement.Entity;

import java.util.List;

public class User {
    private String userId;
    private List<Integer> seats;
    private String date;
    private String slot;
    private String movieName;
    private double totalAmount;

    public User() {
    }

    public User(String userId, List<Integer> seats, String date, String slot, String movieName, double totalAmount) {
        this.userId = userId;
        this.seats = seats;
        this.date = date;
        this.slot = slot;
        this.movieName = movieName;
        this.totalAmount = totalAmount;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
