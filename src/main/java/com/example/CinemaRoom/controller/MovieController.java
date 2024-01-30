package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.dto.*;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {

    @Autowired
    private SeatsService seatsService;
   // private final StatisticsService statisticsService = new StatisticsService(seatsService.numberOfSeats());
    @Autowired
    private PurchaseService purchaseService;
    private AuthenticationService authenticationService;

    @GetMapping("/seats")
    public SeatsResponse getSeats() {
        return seatsService.covertSeatsToDTO();
    }

    @GetMapping("/stats")
    public StatisticsResponse showStatistics(@RequestParam(name = "password", required = false) String passwordRequest) {
        authenticationService.validate(passwordRequest);
        return new StatisticsResponse(purchaseService.getStatisticsService().getStatistics());
    }

    @PostMapping("/return")
    public SeatResponse returnTicket(@RequestBody TokenRequest tokenRequest) {
        return purchaseService.returnTicket(tokenRequest.token()).ticket();
    }

    @PostMapping("/purchase")
    public TicketResponse ticketPurchase(@Validated @RequestBody PurchaseRequest purchaseRequest) {
        return purchaseService.ticketResponse(purchaseRequest.row(), purchaseRequest.column());
    }
}
