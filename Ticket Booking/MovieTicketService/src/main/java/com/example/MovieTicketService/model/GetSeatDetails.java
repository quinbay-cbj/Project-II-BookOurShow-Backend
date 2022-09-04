package com.example.MovieTicketService.model;



public class GetSeatDetails {
    private String name;
    private String date;
    private String slot;

    public GetSeatDetails() {
    }

    public GetSeatDetails(String name, String date, String slot) {
        this.name = name;
        this.date = date;
        this.slot = slot;
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

    @Override
    public String toString() {
        return "GetSeatDetails{" +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", slot='" + slot + '\'' +
                '}';
    }
}
