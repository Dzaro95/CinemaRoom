package com.example.CinemaRoom.model;


public record Statistics(int income, int available,int purchased) {
    public Statistics(int available) {
        this(0,available,0);
    }
}
