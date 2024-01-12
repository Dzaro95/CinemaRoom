package com.example.CinemaRoom.seat;

public class Seat {
    private int row;
    private int column;
    private int price;

    public Seat() {
    }

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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}


