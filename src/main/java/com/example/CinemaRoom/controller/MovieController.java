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
    public SeatsResponse getSeats() {
        return seatsService.covertSeatsToDTO();
    }

    @GetMapping("/seat")
    public List<Seats> getSeat() {
        return seatsService.getAllSeatsTest();
    }

    @GetMapping("/stats")
    public StatisticsResponse showStatistics(@RequestParam(name = "password", required = false) String passwordRequest) {
        authenticationService.validate(passwordRequest);
        return new StatisticsResponse(purchaseService.getStatisticsService().getStatistics());
    }

    @PostMapping("/return")
    public SeatResponse returnTicket(@RequestBody TokenRequest tokenRequest) {
        SeatResponse seat = purchaseService.returnTicket(tokenRequest.token());
        return new SeatResponse(seat.row(), seat.column(), seat.price());
    }

    @PostMapping("/purchase")
    public TicketResponse ticketPurchase(@Validated @RequestBody PurchaseRequest purchaseRequest) {
        SeatResponse seat = seatsService.findSeat(purchaseRequest.row(), purchaseRequest.column());
        Ticket ticket = purchaseService.purchaseSeat(seat);
        return new TicketResponse(ticket.token(), ticket.ticket());
    }

    @PostMapping("/seat")
    public Seat createUser(@RequestBody Seat seat) {
        return seatsService.createSeat(seat);
    }
}
