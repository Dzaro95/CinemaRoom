package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;

public record TicketDTO(String token, Seat ticket) {}
/*
public class TicketPurchase {
    private String token;
    private Seat ticket;

    public TicketPurchase(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}

 */
