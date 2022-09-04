package com.example.UserMicroServices.Constant;

import org.springframework.stereotype.Component;

import static com.example.UserMicroServices.Constant.ConstantClass.PASSWORD_MIN;

@Component
public class ValidateClass {

    public static boolean validatePassword(String password) {

        return password != null && (password.length() >= PASSWORD_MIN && password.length() <= ConstantClass.PASSWORD_MAX);
    }
//&&(password.matches(ConstantClass.PASSWORD_REGEX));

    public static boolean validateContact(String phoneNumber) {

        return phoneNumber != null && phoneNumber.matches(ConstantClass.CONTACT_REGEX) &&
                phoneNumber.length() == ConstantClass.MOBILE_NUMBER_LENGTH;
    }

    public static boolean validateName(String name) {
        return name != null && name.matches(ConstantClass.NAME_REGEX);
    }

}
