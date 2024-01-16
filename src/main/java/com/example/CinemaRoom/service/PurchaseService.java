package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.StatisticsResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.dto.TicketDTO;
import com.example.CinemaRoom.dto.SeatDTO;
import com.example.CinemaRoom.model.Seat;

import java.util.*;

public class PurchaseService {
    private StatisticsService statisticsService;

    private SeatDTO seatDTO;

    private TicketDTO ticketDTO;
    private Map<String, SeatDTO> allTicketPurchased = Collections.synchronizedMap(new HashMap<>());

    public PurchaseService() {
    }

    public PurchaseService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public SeatDTO returnTicket(String uuid) {
        if(allTicketPurchased.containsKey(uuid)) {
            seatDTO = allTicketPurchased.get(uuid);
            allTicketPurchased.remove(uuid);
            return seatDTO;
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }

    public void addTicketPurchase(Seat seat) {
        if (checkPurchased(seat)) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            ticketDTO = new TicketDTO(UUID.randomUUID().toString(),seat);
            allTicketPurchased.put(ticketDTO.token(), ticketDTO.ticket());
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
    public TicketDTO getTicketPurchase() {
        return ticketDTO;
    }

    public SeatDTO getTicketReturn() {
        return seatDTO;
    }

    public StatisticsResponse getStatisticResponse() {
        return statisticsResponse;
    }
}
