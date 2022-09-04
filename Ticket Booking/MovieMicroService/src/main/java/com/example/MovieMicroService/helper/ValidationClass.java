package com.example.MovieMicroService.helper;


import java.time.LocalDate;

public class ValidationClass {


    public static boolean validateName(String name){
        return name != null && !(name.trim()).isEmpty() ;
    }

    public static boolean validateDuration(int duration){
        return duration <= ConstantClass.MOVIE_MAX_MINUTES && duration >= ConstantClass.MOVIE_MIN_MINUTES;
    }

    public static boolean validateGenre(String genre){
        return genre != null && !(genre.trim()).isEmpty();
    }

    public static boolean validateRating(String rating){
        return rating != null && !(rating.trim()).isEmpty();
    }

    public static boolean validateDescription(String description){
        return description != null && !(description.trim()).isEmpty();
    }

    public static boolean validatePrice( int normalPrice , int executivePrice , int premiumPrice ){
        return normalPrice >= 0 && executivePrice >= 0 && premiumPrice >= 0 ;
    }

    public static boolean validateDate(String startDate , String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        LocalDate currentDate = LocalDate.now();
        return !start.isAfter(end) && start.isAfter(currentDate);
    }

    public static boolean validateSlots(String slots[]){
        return slots.length > 0;
    }

    public static boolean validateImageUrl(String imageUrl){
        return imageUrl != null && !(imageUrl.trim()).isEmpty();
    }


}
