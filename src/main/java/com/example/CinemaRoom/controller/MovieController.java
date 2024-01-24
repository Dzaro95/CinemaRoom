package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.dto.*;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private final SeatsService seatsService = new SeatsService();
    private final StatisticsService statisticsService = new StatisticsService(seatsService.numberOfSeats());
    private final PurchaseService purchaseService = new PurchaseService(statisticsService);
    private final AuthenticationService authenticationService = new AuthenticationService();

    @GetMapping("/seats")
    public SeatsDTO getSeats() {
        return seatsService.covertSeatsToDTO(new Seats());
    }

    @GetMapping("/sea")
    public List<Seat> getSea() {
        return seatsService.getAllSeatTest();
    }

    @GetMapping("/stats")
    public StatisticsResponse showStatistics(@RequestParam(name = "password", required = false) String passwordRequest) {
        authenticationService.validate(passwordRequest);
        return new StatisticsResponse(purchaseService.getStatisticsService().getStatistics());
    }

    @PostMapping("/return")
    public SeatResponse returnTicket(@RequestBody TokenRequest tokenRequest) {
        Seat seat = purchaseService.returnTicket(tokenRequest.token());
        return new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice());
    }

    @PostMapping("/purchase")
    public TicketResponse ticketPurchase(@Validated @RequestBody PurchaseRequest purchaseRequest) {
        Seat seat = seatsService.findSeat(purchaseRequest.row(), purchaseRequest.column());
        Ticket ticket = purchaseService.purchaseSeat(seat);
        return new TicketResponse(ticket.token(), ticket.ticket());
    }
}
