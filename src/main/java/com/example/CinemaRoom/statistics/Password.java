package com.example.CinemaRoom.statistics;

public class Password {

    private static final String PASSWORD = "super_secret";

    public static boolean isValid(String password) {
       return  PASSWORD.equals(password);
    }
}
