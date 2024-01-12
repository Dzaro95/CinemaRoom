package com.example.CinemaRoom.exception;

public class FormatException {
    private final String error;

    public FormatException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
