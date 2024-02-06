package com.example.CinemaRoom.service;

import com.example.CinemaRoom.model.Statistics;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    public Statistics getStatistics() {
        generateAvailable();
        List<Ticket> ticketList = ticketRepository.findAll();
        ticketList.forEach(ticket -> {
            statistics.set ticketRepository.findTicketBySeat(ticket.getSeat())
        });
        return statistics;
    }
}
