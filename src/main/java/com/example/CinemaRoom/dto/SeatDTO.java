package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;

public record SeatDTO(
    int row,

    int column,
    int price)
{ }
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
