package com.example.MovieMicroService.helper;

public class ConstantClass {



    public static final String CROSS_ORGIN = "*";


      //  Mapping

    public static final String ADD_MOVIE = "/addMovie";
    public static final String GET_MOVIE_DETAILS = "/movie/{movieId}";
    public static final String MOVIES = "/movies";
    public static final String MOVIE_BY_NAME = "/movieByName/{name}";
    public static final String UPDATE = "/update";




    public static final String CHECK_AVAIL_LINK = "http://localhost:8000/checkAvailability";
    public static final String ADD_TICKET_BLOCK_LINK = "http://localhost:8000/addTicketBlock";
    public static final String UPDATE_MOVIE_LINK = "http://localhost:8000/update";

    public static final String SLOT_AVAILABLE_MSG = "Slot Available";
    public static final String INSERTED_SUCCESSFULLY_MSG = "Inserted Successfully";

    // Error messages

    public static final String INVALID_DATE_MSG = "Creation of Movie should be in upcoming date..";
    public static final String INVALID_DESCRIPTION_MSG = "Description can't be null or Empty";
    public static final String INVALID_DURATION_MSG = "Duration should be minimum 20 minutes and maximum of 180 minutes";
    public static final String INVALID_GENRE_MSG = "Genre can't be null or Empty";
    public static final String INVALID_IMAGEURL_MSG = "ImageUrl can't be empty of null..";
    public static final String INVALID_NAME_MSG = "Null or empty Name is not allowed";
    public static final String INVALID_PRICE_MSG = "Price can't be Negative";
    public static final String INVALID_RATING_MSG ="Rating can't be null or Empty";
    public static final String INVALID_SLOTS_MSG =  "Slots can't be Empty..";
    public static final String MOVIE_NOT_FOUND_MSG = "Movie not found with this Property -> ";
    public static final String NO_RECORD_MSG ="No Record Found in DataBase";


    public static final String MOVIE_ALREADY_EXIST_MSG = "Movie Already exist";


    //Validation

    public static final int MOVIE_MIN_MINUTES = 20;
    public static final int MOVIE_MAX_MINUTES = 180;


    //Success return message
    public static String returnInsertedSuccess(String name,String movieId){
        return "inserted movie : "+ name+" with ID : "+ movieId;
    }

}
