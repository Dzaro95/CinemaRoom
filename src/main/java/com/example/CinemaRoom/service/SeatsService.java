package com.example.CinemaRoom.service;


import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatsService {

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int PREMIUM_ROWS = 4;
    private static final int PREMIUM_PRICE = 10;
    private static final int STANDARD_PRICE = 8;
    private final List<Seat> seats = new ArrayList<>();

    public SeatsService() {
        for (int row = 1; row <= ROWS; row++) {
            for (int column = 1; column <= COLUMNS; column++) {
                seats.add(new Seat(row, column, getPriceForRow(row)));
            }
        }
    }

    public Seat findSeat(int row, int column) {
        Seat seat = new Seat(row, column, getPriceForRow(row));
        if (seats.contains(seat)) {
            return seat;
        } else {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
    }

    private int getPriceForRow(int row) {
        return row <= PREMIUM_ROWS ? PREMIUM_PRICE : STANDARD_PRICE;
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int numberOfSeats() {
        return ROWS * COLUMNS;
    }
}
