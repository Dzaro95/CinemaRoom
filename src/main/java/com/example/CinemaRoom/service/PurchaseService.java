package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.dto.TicketResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private StatisticsService statisticsService;

    public TicketResponse ticketResponse(int row, int column) {
        Ticket ticket = purchaseSeat(row, column).get(0);
        Seat seat = seatRepository.findById(ticket.getSeat()).get();
        return new TicketResponse(ticket.getToken(), new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
    }

    public List<Ticket> purchaseSeat(int row, int column) {
        Seat seat = findSeatByRowAndColumn(row, column);
        saveTicket(seat);
        statisticsService.registerPurchase(seat.getPrice());
        return ticketRepository.findTicketBySeat(seat.getId());
    }

    public Seat findSeatByRowAndColumn(int row, int column) {
        if(seatRepository.findSeatByRowAndColumn(row, column).isEmpty()) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
        else {
            List<Seat> seat = seatRepository.findSeatByRowAndColumn(row, column);
            return seat.get(0);
        }
    }

    public void saveTicket(Seat seat) {
        if (!ticketRepository.findTicketBySeat(seat.getId()).isEmpty()) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            ticketRepository.save(new Ticket(UUID.randomUUID().toString(), seat.getId()));
        }
    }

    public Ticket findSeatByToken(String token) {
        List<Ticket> ticket = ticketRepository.findAllById(Collections.singleton(token));
        if(ticket.isEmpty()) {
            throw new PurchaseException("Wrong token!");
        }
        else {
          return ticket.get(0);
        }
    }

    public TicketResponse returnTicket(String token) {
        Ticket ticket = findSeatByToken(token);
        Seat seat = seatRepository.findById(ticket.getSeat()).get();
        ticketRepository.deleteById(token);
        statisticsService.registerReturn(seat.getPrice());
        return new TicketResponse(ticket.getToken(), new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
    }

    public StatisticsService getStatisticsService() {
        return statisticsService;
    }
}
