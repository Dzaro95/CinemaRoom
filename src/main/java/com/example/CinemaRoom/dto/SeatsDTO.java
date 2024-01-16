package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;
import lombok.Data;

import java.util.List;
@Data
public class SeatsDTO {
        //long id;
        long rows;

        int columns;
        List<Seat> seat;
}
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
