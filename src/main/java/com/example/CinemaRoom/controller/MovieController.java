package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.exception.StatisticsException;
import com.example.CinemaRoom.purchaseAndReturn.TicketPurchased;
import com.example.CinemaRoom.purchaseAndReturn.TicketReturn;
import com.example.CinemaRoom.purchaseAndReturn.Token;
import com.example.CinemaRoom.seat.*;
import com.example.CinemaRoom.service.SeatsService;
import com.example.CinemaRoom.service.TicketService;
import com.example.CinemaRoom.service.StatisticsService;
import com.example.CinemaRoom.statistics.Password;
import com.example.CinemaRoom.statistics.Statistics;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private TicketService ticketService = new TicketService();
    private StatisticsService statisticsService = new StatisticsService();

    @GetMapping("/seats")
    public SeatsResponse getSeats() {
        return SeatsService.seats();
    }

    @GetMapping("/stats")
    public Statistics showStatistics(@Validated @RequestParam @Nullable String password) {
        if (Password.isValid(password)) {
            return statisticsService.getStatistics();
        } else {
            throw new StatisticsException("The password is wrong!");
        }
    }

    @PostMapping("/return")
    public TicketReturn ticketReturn(@RequestBody Token token) {
        ticketService.returnTicket(token.getToken());
        statisticsService.returnTicket(ticketService.getTicketReturn().ticket().getPrice());
        return ticketService.getTicketReturn();

    }

    @PostMapping("/purchase")
    public TicketPurchased ticketPurchase(@Validated @RequestBody Seat request) {
        Seat ticketPurchase = new Seat(request.getRow(), request.getColumn());
        ticketService.addTicketPurchase(ticketPurchase);
        statisticsService.addPurchasedTicket(ticketPurchase.getPrice());
        return ticketService.getTicketPurchase();
    }
}
