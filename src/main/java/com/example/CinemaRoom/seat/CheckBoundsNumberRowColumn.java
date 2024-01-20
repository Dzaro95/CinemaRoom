package com.example.CinemaRoom.seat;

import com.example.CinemaRoom.exception.PurchaseInfoException;
import com.example.CinemaRoom.seat.Seats;

public class CheckBoundsNumberRowColumn {
    public static void check(Seats seats, int rows, int columns) {
        if(seats.getRows() < rows || seats.getColumns() < columns) {
            throw new PurchaseInfoException("The number of a row or a column is out of bounds!");
        } else if ( rows < 1 || columns < 1) {
            throw new PurchaseInfoException("The number of a row or a column is out of bounds!");
        }
    }
}
