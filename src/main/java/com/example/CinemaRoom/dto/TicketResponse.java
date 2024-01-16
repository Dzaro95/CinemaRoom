package com.example.CinemaRoom.dto;

public record TicketResponse(String token, SeatResponse ticket) {}
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
