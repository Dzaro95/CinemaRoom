package com.example.CinemaRoom.service;


import com.example.CinemaRoom.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatsInformation {
    public final int ROWS = 9;
    public final int COLUMNS = 9;
    private final List<Seat> SEATS;


    public SeatsInformation() {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= this.ROWS; row++) {
            for(int column = 1; column <= this.COLUMNS; column++) {
                seatList.add(new Seat(row,column,row <= 4 ? 10 : 8));
            }
        }
        this.SEATS = seatList;
    }
    public int priceResponse(int row) {

        return row <= 4 ? 10 : 8;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public List<Seat> getSEATS() {
        return SEATS;
    }
    public int numberOfSeats() {
        return ROWS * COLUMNS;
    }


}
