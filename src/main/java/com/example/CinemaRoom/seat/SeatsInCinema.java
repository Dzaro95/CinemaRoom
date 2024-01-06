package com.example.CinemaRoom.seat;


import java.util.ArrayList;
import java.util.List;

public class SeatsInCinema {
    private static final int rows = 9;
    private static final int columns = 9;

    public static int checkPrice(int row) {
        if(row <= 4) {
            return 10;
        } else {
            return 8;
        }
    }

    public static List<Seat> seatList(int rows, int columns) {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= rows; row++) {
            for(int column = 1; column <= columns; column++) {
                seatList.add(new Seat(row,column,checkPrice(row)));
            }
        }
        return seatList;
    }
    public static Seats seats() {
        //int rows = 9;
        //int columns = 9;
        return new Seats(rows,columns,seatList(rows,columns));
    }

    public static int numberOfSeatsInCinema() {
        return rows * columns;
    }

}
