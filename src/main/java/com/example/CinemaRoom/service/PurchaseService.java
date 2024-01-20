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
    public PurchaseService(int available) {
        this.statisticsService = new StatisticsService(available);
    }
    public Seat returnTicket(String uuid) {
        if(allTicketPurchased.containsKey(uuid)) {
            seatResponse = allTicketPurchased.get(uuid);
            allTicketPurchased.remove(uuid);
            statisticsService.setStatistics(statisticsService.registerReturn(statisticsService.getStatistics(),seatResponse.price()));
            return new Seat(seatResponse.row(), seatResponse.column(), seatResponse.price());
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }
    public TicketResponse purchaseSeat(Seat seat) {
        if (checkPurchased(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            ticketResponse = new TicketResponse(UUID.randomUUID().toString(),new SeatResponse(seat.row(),seat.column(),seat.price()));
            allTicketPurchased.put(ticketResponse.token(), ticketResponse.ticket());
            statisticsService.setStatistics(statisticsService.registerPurchase(
                    statisticsService.getStatistics(),
                    ticketResponse.ticket().price()));
            return new TicketResponse(ticketResponse.token(),ticketResponse.ticket());
        }
    }
    public boolean checkPurchased(Seat seat) {
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
    public StatisticsService getStatisticsService() {
        return statisticsService;
    }
}
