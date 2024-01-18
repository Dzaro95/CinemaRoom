package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;
import lombok.Data;

import java.util.List;

public record SeatsDTO(
        //long id;
        int rows,

        int columns)
{}
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
