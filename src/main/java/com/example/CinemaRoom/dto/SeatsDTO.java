package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;
import lombok.Data;

import java.util.List;

public record SeatsDTO(int rows, int column, List<SeatDTO> seats) { }
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
