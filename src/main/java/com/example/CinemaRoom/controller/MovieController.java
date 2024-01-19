package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.dto.*;
//import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.service.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {


    private final SeatService seatService;
    /*
    private final Seats seats = new Seats();
    private final StatisticsService statisticsService = new StatisticsService(seats.numberOfSeats());
    private final PurchaseService purchaseService = new PurchaseService(statisticsService);
    private final AuthenticationService authenticationService = new AuthenticationService();

     */

    @GetMapping("/seats")
    public SeatsDTO getSeats() {
        return seatService.covertSeatsToDTO(new Seats());
    }
/*
    @GetMapping("/stats")
    public StatisticsResponse showStatistics(@RequestParam(name = "password" ,required = false) String password) {
        authenticationService.isValid(password);
        return new StatisticsResponse(statisticsService.getStatistics());
    }

    @PostMapping("/return")
    public SeatsDTO returnTicket(@RequestBody TokenRequest tokenRequest) {
        SeatsDTO seat = purchaseService.returnTicket(tokenRequest.token());
        //statisticsService.registerReturn(purchaseService.getTicketReturn().ticket().price());
        return purchaseService.getTicketReturn();

    }

    @PostMapping("/purchase")
    public TicketDTO ticketPurchase(@Validated @RequestBody Seat request) {
        Seat ticketPurchase = new Seat(request.row(), request.column());
        purchaseService.addTicketPurchase(ticketPurchase);
        statisticsService.registerPurchase(ticketPurchase.price());
        return purchaseService.getTicketPurchase();
    }

 */
}
