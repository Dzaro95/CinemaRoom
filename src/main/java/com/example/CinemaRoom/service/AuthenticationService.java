package com.example.CinemaRoom.service;

import com.example.CinemaRoom.exception.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final String PASSWORD = "super_secret";

    public void validate(String password) {
        if (!PASSWORD.equals(password)) {
            throw new UnauthorizedException("The password is wrong!");
        }
    }
}
