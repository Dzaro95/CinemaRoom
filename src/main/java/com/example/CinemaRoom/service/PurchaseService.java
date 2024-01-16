package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.StatisticsResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.dto.TicketDTO;
import com.example.CinemaRoom.dto.SeatsDTO;
import com.example.CinemaRoom.model.Seat;

import java.util.*;

public class PurchaseService {
    private StatisticsService statisticsService;

    private SeatsDTO seatsDTO;

    private TicketDTO ticketDTO;
    private Map<String, SeatsDTO> allTicketPurchased = Collections.synchronizedMap(new HashMap<>());

    public PurchaseService() {
    }

    public PurchaseService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public SeatsDTO returnTicket(String uuid) {
        if(allTicketPurchased.containsKey(uuid)) {
            seatsDTO = allTicketPurchased.get(uuid);
            allTicketPurchased.remove(uuid);
            return seatsDTO;
        } else {
            throw new PurchaseException("Wrong token!");
        }
    }
/*
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
            if(seatCheck.row() == seat.row() && seatCheck.column() == seat.column()) {
                check = true;
            }
        }
        return check;
    }
    public TicketDTO getTicketPurchase() {
        return ticketDTO;
    }

    public SeatsDTO getTicketReturn() {
        return seatsDTO;
    }

    public StatisticsResponse getStatisticResponse() {
        return statisticsResponse;
    }

 */
}
