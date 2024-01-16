package com.example.CinemaRoom;

import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.service.SeatsInformation;

public class Bound {
    public static void isValid(SeatsInformation seatsInformation, int row, int column) {
        if (seatsInformation.ROWS < row || seatsInformation.COLUMNS < column) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        } else if (row < 1 || column < 1) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
    }

}

