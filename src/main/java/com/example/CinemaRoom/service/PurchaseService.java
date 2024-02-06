package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.dto.TicketResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {

    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;

    @Autowired
    private SeatsService seatsService;

    @Autowired
    public void CinemaRoomApplication(SeatRepository seatRepository,TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    private void saveTicket(Seat seat) {
        if (!ticketRepository.findTicketBySeat(seat).isEmpty()) {
            throw new PurchaseException("The ticket has been already purchased!");
        } else {
            ticketRepository.save(new Ticket(UUID.randomUUID().toString(), seat));
        }
    }

    private Ticket findSeatByToken(String token) {
        List<Ticket> ticket = ticketRepository.findAllById(Collections.singleton(token));
        if(ticket.isEmpty()) {
            throw new PurchaseException("Wrong token!");
        }
        else {
          return ticket.get(0);
        }
    }

    private Ticket purchaseSeat(int row, int column) {
        Seat seat = seatsService.findSeatByRowAndColumn(row, column);
        saveTicket(seat);
        return ticketRepository.findTicketBySeat(seat).get(0);
    }

    public TicketResponse purchaseTicket(int row, int column) {
        Ticket ticket = purchaseSeat(row, column);
        Seat seat = seatRepository.findById(ticket.getSeat().getId()).get();
        return new TicketResponse(ticket.getToken(), new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
    }

    public TicketResponse returnTicket(String token) {
        Ticket ticket = findSeatByToken(token);
        Seat seat = seatRepository.findById(ticket.getSeat().getId()).get();
        ticketRepository.deleteById(token);
        return new TicketResponse(ticket.getToken(), new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
    }
}
