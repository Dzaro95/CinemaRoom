package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.dto.*;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.service.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {


    private final SeatsService seatsService = new SeatsService();
    private final StatisticsService statisticsService = new StatisticsService(seatsService.numberOfSeats());
    private final PurchaseService purchaseService = new PurchaseService(statisticsService);
    private final AuthenticationService authenticationService = new AuthenticationService();

    @GetMapping("/seats")
    public SeatsResponse getSeats() {

        return new SeatsResponse(seatsService.getROWS(), seatsService.getCOLUMNS(), seatsService.getSEATS());
    }

    @GetMapping("/stats")
    public StatisticsResponse showStatistics(@RequestParam(name = "password" ,required = false) String password) {
        authenticationService.isValid(password);
        return new StatisticsResponse(statisticsService.getStatistics());
    }

    @PostMapping("/return")
    public SeatResponse returnTicket(@RequestBody TokenRequest tokenRequest) {
        Seat seat = purchaseService.returnTicket(tokenRequest.token());
        return new SeatResponse(seat.row(),seat.column(),seat.price());

    }

    @PostMapping("/purchase")
    public TicketResponse ticketPurchase(@Validated @RequestBody Seat request) {
        SeatResponse ticketPurchase = seatsService.findSeat(request.row(), request.column());
        return new TicketResponse(purchaseService.purchaseSeat(ticketPurchase).token(),
                purchaseService.purchaseSeat(ticketPurchase).ticket());
    }


}
