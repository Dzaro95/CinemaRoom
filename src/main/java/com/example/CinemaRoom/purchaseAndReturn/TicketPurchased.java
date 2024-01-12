package com.example.CinemaRoom.purchaseAndReturn;

import com.example.CinemaRoom.seat.Seat;
public record TicketPurchased(String token, Seat ticket) {}
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
