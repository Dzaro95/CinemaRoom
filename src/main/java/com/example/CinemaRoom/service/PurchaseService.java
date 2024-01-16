package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.dto.TicketResponse;
import com.example.CinemaRoom.model.Seat;

import java.util.*;

public class PurchaseService {
    private StatisticsService statisticsService;
    private SeatResponse seatResponse;
    private TicketResponse ticketResponse;
    private Map<String, SeatResponse> allTicketPurchased = Collections.synchronizedMap(new HashMap<>());

    public PurchaseService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public Seat returnTicket(String uuid) {
        if(allTicketPurchased.containsKey(uuid)) {
            seatResponse = allTicketPurchased.get(uuid);
            allTicketPurchased.remove(uuid);
            statisticsService.registerReturn(statisticsService.getStatistics(),seatResponse.price());
            return new Seat(seatResponse.row(), seatResponse.column(), seatResponse.price());
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }

    public TicketResponse purchaseSeat(SeatResponse seat) {
        if (checkPurchased(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            ticketResponse = new TicketResponse(UUID.randomUUID().toString(),seat);
            allTicketPurchased.put(ticketResponse.token(), ticketResponse.ticket());
            statisticsService.registerPurchase(statisticsService.getStatistics(), ticketResponse.ticket().price());
            return ticketResponse;
        }
    }
    public boolean checkPurchased(SeatResponse seat) {
        boolean check = false;
        for(SeatResponse seatCheck : allTicketPurchased.values()) {
            if(seatCheck.row() == seat.row() && seatCheck.column() == seat.column()) {
                check = true;
            }
        }
        return check;
    }
    public TicketResponse getTicketPurchase() {
        return ticketResponse;
    }

    public SeatResponse getTicketReturn() {
        return seatResponse;
    }

    public StatisticsService getStatisticsService() {
        return statisticsService;
    }
}
