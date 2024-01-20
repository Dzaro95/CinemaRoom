package com.example.CinemaRoom.seat;

public class PriceForSeat {
    public static int checkPrice(int row) {
        if(row <= 4) {
            return 10;
        } else {
            return 8;
        }
    }
}
