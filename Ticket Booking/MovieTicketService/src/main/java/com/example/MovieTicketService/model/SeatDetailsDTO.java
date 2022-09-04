package com.example.MovieTicketService.model;

public class SeatDetailsDTO {


    private int seatNumber;
    private int amount;
    private String userId;

    public SeatDetailsDTO() {
    }

    public SeatDetailsDTO(int seatNumber, int amount, String userId) {
        this.seatNumber = seatNumber;
        this.amount = amount;
        this.userId = userId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SeatDetails{" +
                "seatNumber=" + seatNumber +
                ", amount=" + amount +
                ", userId='" + userId + '\'' +
                '}';
    }


}
