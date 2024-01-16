package com.example.CinemaRoom.service;

import com.example.CinemaRoom.exception.UnauthorizedException;

public class AuthenticationService {

    private final String PASSWORD = "super_secret";

    public  boolean isValid(String password) {
        if (PASSWORD.equals(password)) {
            return true;
        } else {
            throw new UnauthorizedException("The password is wrong!");
        }
    }
}
