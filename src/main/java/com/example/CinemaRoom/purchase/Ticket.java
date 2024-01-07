package com.example.CinemaRoom.purchase;


import com.example.CinemaRoom.exception.PurchaseInfoException;
import com.example.CinemaRoom.seat.Seat;

import java.util.*;

public class Ticket {

    private String token;
    private Seat ticket;

    private List<Seat> ticketList = Collections.synchronizedList(new ArrayList<>());
    private Map<String, Seat> ticketMap = Collections.synchronizedMap(new HashMap<>());

    public Ticket() {
    }
    public ReturnTicket deleteTicket(String uuid) {
        ReturnTicket canceledTicket = new ReturnTicket(ticketMap.get(uuid));
        ticketList.remove(ticketMap.get(uuid));
        ticketMap.remove(uuid);
        return canceledTicket;
    }
    public void checkToken(String uuid) {
        if(ticketMap.containsKey(uuid)) {

        } else {
            throw new PurchaseInfoException("Wrong token!");
        }
    }

    public int priceForRow(String uuid) {
        Seat seatPrice = ticketMap.get(uuid);
        return seatPrice.getPrice();
    }

    public void addPurchaseSeat(Seat seat) {
        if (checkPurchased(seat)) {
            throw new PurchaseInfoException("The ticket has been already purchased!");
        } else {
            this.token = TokenGeneration.getToken().toString();
            this.ticket = seat;
            ticketList.add(seat);
            ticketMap.put(token, seat);
        }
    }
    public boolean checkPurchased(Seat seat) {
        boolean check = false;
        for(Seat seatCheck : ticketList) {
            if(seatCheck.getRow() == seat.getRow() && seatCheck.getColumn() == seat.getColumn()) {
                check = true;
            }
        }
        return check;
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }

}

