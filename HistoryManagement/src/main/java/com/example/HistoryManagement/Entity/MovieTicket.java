package com.example.HistoryManagement.Entity;

import org.springframework.stereotype.Component;

import java.util.List;


public class MovieTicket {

    private String movieId;
    private String name;
    private String date;
    private String slot;
    private List<SeatDetails> seat;

    public MovieTicket() {
    }

    public MovieTicket(String movieId, String name, String date, String slot, List<SeatDetails> seat) {
        this.movieId = movieId;
        this.name = name;
        this.date = date;
        this.slot = slot;
        this.seat = seat;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<SeatDetails> getSeat() {
        return seat;
    }

    public void setSeat(List<SeatDetails> seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "MovieTicket{" +
                "movieId='" + movieId + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", slot='" + slot + '\'' +
                ", seat=" + seat +
                '}';
    }
}
