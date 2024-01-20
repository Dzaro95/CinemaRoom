package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.dto.TicketResponse;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Ticket;

import java.util.*;

public class PurchaseService {
    private StatisticsService statisticsService;
    private Map<String, Seat> allTicketPurchased = Collections.synchronizedMap(new HashMap<>());
    public PurchaseService(StatisticsService statisticsService) {
        this.statisticsService =  statisticsService;
    }
    public Seat returnTicket(String token) {
        if(allTicketPurchased.containsKey(token)) {
            Seat seat = allTicketPurchased.get(token);
            allTicketPurchased.remove(token);
            statisticsService.registerReturn(seat.price());
            return seat;
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }
    public Ticket purchaseSeat(Seat seat) {
        if(allTicketPurchased.containsValue(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            String token = UUID.randomUUID().toString();
            allTicketPurchased.put(token, seat);
            statisticsService.registerPurchase(seat.price());
            return new Ticket(token,seat);
        }
    }
    public StatisticsService getStatisticsService() {
        return statisticsService;
    }
}
