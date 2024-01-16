package com.example.CinemaRoom;

import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.service.SeatsService;

public class Bound {
    public static void isValid(SeatsService seatsService, int row, int column) {
        if (seatsService.ROWS < row || seatsService.COLUMNS < column) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        } else if (row < 1 || column < 1) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
    }

}

