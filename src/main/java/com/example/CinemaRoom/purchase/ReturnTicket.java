package com.example.CinemaRoom.purchase;

import com.example.CinemaRoom.seat.Seat;

public class ReturnTicket {
    private Seat ticket;

    public ReturnTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }
}
