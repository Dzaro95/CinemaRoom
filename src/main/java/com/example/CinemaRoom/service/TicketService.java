package com.example.CinemaRoom.service;

import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.purchaseAndReturn.TicketPurchased;
import com.example.CinemaRoom.purchaseAndReturn.TicketReturn;
import com.example.CinemaRoom.purchaseAndReturn.TokenGeneration;
import com.example.CinemaRoom.seat.Seat;

import java.util.*;

public class TicketService {

    private TicketReturn ticketReturn;

    private TicketPurchased ticketPurchased;
    private Map<String, Seat> allTicketPurchased = Collections.synchronizedMap(new HashMap<>());

    public TicketService() {
    }
    public void returnTicket(String uuid) {
        if(allTicketPurchased.containsKey(uuid)) {
            ticketReturn = new TicketReturn(allTicketPurchased.get(uuid));
            allTicketPurchased.remove(uuid);
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }

    public void addTicketPurchase(Seat seat) {
        if (checkPurchased(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            ticketPurchased = new TicketPurchased(TokenGeneration.getToken().toString(),seat);
            allTicketPurchased.put(ticketPurchased.token(), ticketPurchased.ticket());
        }
    }
    public boolean checkPurchased(Seat seat) {
        boolean check = false;
        for(Seat seatCheck : allTicketPurchased.values()) {
            if(seatCheck.getRow() == seat.getRow() && seatCheck.getColumn() == seat.getColumn()) {
                check = true;
            }
        }
        return check;
    }
    public TicketPurchased getTicketPurchase() {
        return ticketPurchased;
    }

    public TicketReturn getTicketReturn() {
        return ticketReturn;
    }
}
