package com.example.UserMicroServices.Constant;

public class ConstantClass {

    public final static String NAME_REGEX = "[A-Za-z][A-Za-z0-9 ]{2,}$";
    public final static String CONTACT_REGEX = "[0-9]+";
    public final static int MOBILE_NUMBER_LENGTH = 10;
    public final static int PASSWORD_MIN = 8;
    public final static int PASSWORD_MAX = 15;//8-15
    // public final static String PASSWORD_REGEX="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|]).{8,15}$";
//public final static String PASSWORD_REGEX="/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/";
    public final static String ROLE_USER = "user";

    public final static String SUCCESS_MSG = "successfully logedIn";
    public final static int NOT_FOUND_CODE = 404;
    public final static String NOT_FOUND_MSG = "PhoneNumber and Password did't match..";
    public final static String NO_ACCOUNT_FOUND_MSG = "Account does not Exist.. ";


    public final static int SUCCESS_CODE = 200;
    public final static String TOPIC = "findUserId";

    public final static String SUCCESS_CREATE_MSG = "successfully Created..";
    public final static int BAD_REQUEST_CODE = 400;
    public final static String BAD_REQUEST_MSG = "Phone Number or password or some other fields didn't match the requirment..";
    public final static int ACCOUNT_FOUND_CODE = 409;
    public final static String ACCOUNT_FOUND_MSG = "Already Phone Number exist";


}
