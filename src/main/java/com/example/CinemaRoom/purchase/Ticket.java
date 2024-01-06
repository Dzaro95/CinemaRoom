package com.example.CinemaRoom.purchase;


import com.example.CinemaRoom.exception.PurchaseInfoException;
import com.example.CinemaRoom.seat.DeleteSeat;
import com.example.CinemaRoom.seat.Seat;

import java.util.*;

public class Ticket {

    private String token;
    private Seat ticket;

    private List<Seat> ticketList = Collections.synchronizedList(new ArrayList<>());
    private Map<String, Seat> ticketMap = Collections.synchronizedMap(new HashMap<>());

    public Ticket() {
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
    public void deleteTicket(String uuid) {
        ticketList.remove(ticketMap.get(uuid));
        ticketMap.remove(uuid);
    }
    public DeleteSeat checkToken(String uuid) {
        if(ticketMap.containsKey(uuid)) {
            DeleteSeat seatDelete = new DeleteSeat(ticketMap.get(uuid));
            deleteTicket(uuid);
            //statistics.returnTicket(seatDelete.getTicket().getRow());
            return seatDelete;
        } else {
            throw new PurchaseInfoException("Wrong token!");
        }
    }

    public int rowSelectPrice(String uuid) {
        if(ticketMap.containsKey(uuid)) {
            Seat seatPrice = ticketMap.get(uuid);
            //statistics.returnTicket(seatDelete.getTicket().getRow());
            return seatPrice.getPrice();
        } else {
            throw new PurchaseInfoException("Wrong token!");
        }
    }


    public void addPurchaseSeat(Seat seat) {
        if (checkPurchased(seat)) {
            throw new PurchaseInfoException("The ticket has been already purchased!");
        } else {
            this.token = TokenGeneration.getToken().toString();
            this.ticket = seat;
            ticketList.add(seat);
            ticketMap.put(token, seat);
            //statistics.addSoldTicket(SeatsInCinema.checkPrice(seat.getRow()));
        }
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }

    /*
    public List<Seat> getTicket() {
        return ticket;
    }

 */
/*
    public Map<UUID, List<Seat>> getTicketMap() {
        return ticketMap;
    }

 */
}

