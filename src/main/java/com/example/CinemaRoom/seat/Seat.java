package com.example.CinemaRoom.seat;

import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.service.SeatsService;

public class Seat {
    private int row;
    private int column;
    private int price;

    public Seat(int row, int column) {
        if(SeatsService.ROWS < row || SeatsService.COLUMNS < column) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        } else if ( row < 1 || column < 1) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
    }

    public int getPrice() {
        return price;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

}


