package com.example.CinemaRoom.service;


import com.example.CinemaRoom.seat.Seat;
import com.example.CinemaRoom.seat.SeatsResponse;

import java.util.ArrayList;
import java.util.List;

public class SeatsService {
    public static final int ROWS = 9;
    public static final int COLUMNS = 9;
    private static final List<Seat> SEATS = seatList(ROWS,COLUMNS);


    public static List<Seat> seatList(int rows, int columns) {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= rows; row++) {
            for(int column = 1; column <= columns; column++) {
                seatList.add(new Seat(row,column));
            }
        }
        return seatList;
    }

    public SeatsService() {
    }

    public static SeatsResponse seats() {
        return new SeatsResponse(ROWS,COLUMNS,SEATS);
    }

    public static int numberOfSeatsInCinema() {
        return ROWS * COLUMNS;
    }


}
