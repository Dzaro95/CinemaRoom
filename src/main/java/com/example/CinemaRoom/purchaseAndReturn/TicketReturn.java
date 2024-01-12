package com.example.CinemaRoom.purchaseAndReturn;

import com.example.CinemaRoom.seat.Seat;

public record TicketReturn(Seat ticket) {}
/*
public class TicketReturn {
    private Seat ticket;

    public TicketReturn(Seat ticket) {
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }
}

 */
