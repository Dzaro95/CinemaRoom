package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Ticket;
import java.util.*;

public class PurchaseService {

    private StatisticsService statisticsService;
    private Map<String, SeatResponse> allTicketPurchased = Collections.synchronizedMap(new HashMap<>());

    public PurchaseService(StatisticsService statisticsService) {
        this.statisticsService =  statisticsService;
    }

    public SeatResponse returnTicket(String token) {
        if(allTicketPurchased.containsKey(token)) {
            SeatResponse seat = allTicketPurchased.get(token);
            allTicketPurchased.remove(token);
            statisticsService.registerReturn(seat.price());
            return seat;
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }

    public Ticket purchaseSeat(SeatResponse seat) {
        if(allTicketPurchased.containsValue(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            String token = UUID.randomUUID().toString();
            allTicketPurchased.put(token, seat);
            statisticsService.registerPurchase(seat.price());
            return new Ticket(token, seat);
        }
    }

    public StatisticsService getStatisticsService() {
        return statisticsService;
    }
}
