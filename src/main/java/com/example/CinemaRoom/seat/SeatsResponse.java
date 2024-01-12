package com.example.CinemaRoom.seat;


import java.util.List;

public record SeatsResponse(int rows, int columns, List<Seat> seats) {

}

