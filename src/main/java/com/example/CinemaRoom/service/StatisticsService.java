package com.example.CinemaRoom.service;

import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Statistics;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class StatisticsService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TicketRepository ticketRepository;
    private Statistics statistics;

    public void generateAvailable() {
        statistics =  new Statistics(seatRepository.findAll().size());
    }

    public Statistics getStatistic() {
        generateAvailable();
        List<Seat> seatList = new ArrayList<>();
        List<Ticket> ticketList = ticketRepository.findAll();
        for (Ticket ticket : ticketList) {
            seatList.add(seatRepository.findById((ticket.getSeat())).get());
        }
        seatList.forEach(seat -> {
            statistics = new Statistics(statistics.purchased() + seat.getPrice(),
                    statistics.available(), statistics.income() + 1);
        });
        return statistics;
    }
}
