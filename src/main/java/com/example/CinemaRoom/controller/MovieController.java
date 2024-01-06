package com.example.CinemaRoom.controller;

import com.example.CinemaRoom.exception.StatisticsInfoException;
import com.example.CinemaRoom.purchase.CheckBoundsNumberRowColumn;
import com.example.CinemaRoom.purchase.Ticket;
import com.example.CinemaRoom.purchase.Token;
import com.example.CinemaRoom.seat.DeleteSeat;
import com.example.CinemaRoom.seat.Seat;
import com.example.CinemaRoom.seat.Seats;
import com.example.CinemaRoom.seat.SeatsInCinema;
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
    CompleteStatistics completeStatistics = new CompleteStatistics();
    private Statistics statistics = new Statistics(SeatsInCinema.numberOfSeatsInCinema());


    @GetMapping("/seats")
    public Seats getSeats() {
        return seats;
    }

    @GetMapping("/stats")
    public Statistics showStatistics(@Validated @RequestParam Optional<String> password) {//dlaczego działa optional
        if (Password.checkPassword(password)) {
            return completeStatistics.getStatistics();
        } else {
            throw new StatisticsInfoException("The password is wrong!");
        }
    }

    @PostMapping("/return")
    public DeleteSeat returnTicket(@RequestBody Token token) {
        int row = ticket.rowSelectPrice(token.getToken());
        completeStatistics.returnTicket(row);
        return ticket.checkToken(token.getToken());

    }

    @PostMapping("/purchase")
    public Ticket purchaseSeat(@Validated @RequestBody Seat seat) {
        CheckBoundsNumberRowColumn.check(seats, seat.getRow(), seat.getColumn());
        Seat seatPurchase = new Seat(seat.getRow(), seat.getColumn(), SeatsInCinema.checkPrice(seat.getRow()));
        ticket.addPurchaseSeat(seatPurchase);
        completeStatistics.addSoldTicket(seatPurchase.getPrice());
        return ticket;
    }



}
