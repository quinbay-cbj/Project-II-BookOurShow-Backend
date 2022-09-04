package com.example.MovieMicroService.entity;

public class SeatDetails {


    private int seatNumber;
    private boolean bookingStatus;
    private String userId;

    public SeatDetails() {
    }

    public SeatDetails(int seatNumber, boolean bookingStatus, String userId) {
        this.seatNumber = seatNumber;
        this.bookingStatus = bookingStatus;
        this.userId = userId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
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
                ", bookingStatus=" + bookingStatus +
                ", userId='" + userId + '\'' +
                '}';
    }
}
