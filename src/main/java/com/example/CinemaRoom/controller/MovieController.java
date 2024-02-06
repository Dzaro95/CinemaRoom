package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.dto.*;
import com.example.CinemaRoom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private SeatsService seatsService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/seats")
    public SeatsResponse getSeats() {
        return seatsService.getSeats();
    }

    @GetMapping("/stats")
    public StatisticsResponse showStatistics(@RequestParam(name = "password", required = false) String passwordRequest) {
        authenticationService.validate(passwordRequest);
        return new StatisticsResponse(statisticsService.getStatistic());
    }

    @PostMapping("/return")
    public SeatResponse returnTicket(@RequestBody TokenRequest tokenRequest) {
        return purchaseService.returnTicket(tokenRequest.token()).ticket();
    }

    @PostMapping("/purchase")
    public TicketResponse ticketPurchase(@Validated @RequestBody PurchaseRequest purchaseRequest) {
        return purchaseService.purchaseTicket(purchaseRequest.row(), purchaseRequest.column());
    }
}
