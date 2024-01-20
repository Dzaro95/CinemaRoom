package com.example.CinemaRoom.statistics;

import java.util.Optional;

public class Password {
    private static final Optional<String> passwordAccess = "super_secret".describeConstable();
    public static boolean checkPassword(Optional<String> passwordCheck) {
        if (passwordAccess.equals(passwordCheck)) {
            return true;
        } else {
            return false;
        }
    }
}
