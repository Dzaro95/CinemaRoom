package com.example.CinemaRoom.Function;

import com.example.CinemaRoom.model.Seat;
import java.util.ArrayList;
import java.util.List;

public class Function {

    public static List<Seat> seatList(int ROWS, int COLUMNS) {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= ROWS; row++) {
            for (int column = 1; column <= COLUMNS; column++) {
                Seat seat = new Seat();
                seat.setRow(row);
                seat.setColumn(column);
                seat.setPrice(row <= 4 ? 10 : 8);
                seatList.add(seat);
            }
        }
        return seatList;
    }
}
