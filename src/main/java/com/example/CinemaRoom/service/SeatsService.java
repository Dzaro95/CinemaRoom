package com.example.CinemaRoom.service;


import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatsService {
    public final int ROWS = 9;
    public final int COLUMNS = 9;
    private final List<Seat> SEATS;


    public SeatsService() {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= this.ROWS; row++) {
            for(int column = 1; column <= this.COLUMNS; column++) {
                seatList.add(new Seat(row, column,row <= 4 ? 10 : 8));
            }
        }
        this.SEATS = seatList;
    }
    public int priceResponse(int row) {

        return row <= 4 ? 10 : 8;
    }
    public SeatResponse findSeat(int row, int column) {
        Seat seat = new Seat(row,column,row <= 4 ? 10 : 8);
        if (SEATS.contains(seat)) {
            return new SeatResponse(seat.row(),seat.column(),seat.price());
        } else {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
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
