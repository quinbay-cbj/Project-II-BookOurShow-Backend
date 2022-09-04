package com.example.MovieTicketService.model;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class MovieDTO {


    private String movieId;
    private String name;
    private int duration;
    private String genre;
    private String rating;
    private String description;
    private int normalPrice;
    private int executivePrice;
    private int premiumPrice;
    private String startDate;
    private String endDate;
    private String slots[];
    private String imageUrl;
    private String videoUrl;


    public MovieDTO() {
    }

    public MovieDTO(String movieId, String name, int duration, String genre, String rating,
                 String description, int normalPrice, int executivePrice, int premiumPrice,
                 String startDate, String endDate, String[] slots, String imageUrl, String videoUrl) {
        this.movieId = movieId;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
        this.normalPrice = normalPrice;
        this.executivePrice = executivePrice;
        this.premiumPrice = premiumPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.slots = slots;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(int normalPrice) {
        this.normalPrice = normalPrice;
    }

    public int getExecutivePrice() {
        return executivePrice;
    }

    public void setExecutivePrice(int executivePrice) {
        this.executivePrice = executivePrice;
    }

    public int getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(int premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String[] getSlots() {
        return slots;
    }

    public void setSlots(String[] slots) {
        this.slots = slots;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                ", normalPrice=" + normalPrice +
                ", executivePrice=" + executivePrice +
                ", premiumPrice=" + premiumPrice +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", slots=" + Arrays.toString(slots) +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
