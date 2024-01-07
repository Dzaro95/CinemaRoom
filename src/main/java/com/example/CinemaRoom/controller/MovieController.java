package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.exception.StatisticsInfoException;
import com.example.CinemaRoom.seat.CheckBoundsNumberRowColumn;
import com.example.CinemaRoom.purchase.ReturnTicket;
import com.example.CinemaRoom.purchase.Ticket;
import com.example.CinemaRoom.purchase.Token;
import com.example.CinemaRoom.seat.*;
import com.example.CinemaRoom.statistics.CompleteStatistics;
import com.example.CinemaRoom.statistics.Password;
import com.example.CinemaRoom.statistics.Statistics;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {
    private Ticket ticket = new Ticket();
    private Seats seats = SeatsInCinema.seats();
    private CompleteStatistics completeStatistics = new CompleteStatistics();

    @GetMapping("/seats")
    public Seats getSeats() {
        return seats;
    }

    @GetMapping("/stats")
    public Statistics showStatistics(@Validated @RequestParam Optional<String> password) {//zapytać o wyjaśnienie optional
        if (Password.checkPassword(password)) {
            return completeStatistics.getStatistics();
        } else {
            throw new StatisticsInfoException("The password is wrong!");
        }
    }

    @PostMapping("/return")
    public ReturnTicket returnTicket(@RequestBody Token token) {
        ticket.checkToken(token.getToken());
        completeStatistics.returnTicket(ticket.priceForRow(token.getToken()));
        return ticket.deleteTicket(token.getToken());

    }

    @PostMapping("/purchase")
    public Ticket purchaseSeat(@Validated @RequestBody Seat seat) {
        CheckBoundsNumberRowColumn.check(seats, seat.getRow(), seat.getColumn());
        Seat seatPurchase = new Seat(seat.getRow(), seat.getColumn(), PriceForSeat.checkPrice(seat.getRow()));
        ticket.addPurchaseSeat(seatPurchase);
        completeStatistics.addSoldTicket(seatPurchase.getPrice());
        return ticket;
    }



}
