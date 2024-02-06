package com.example.CinemaRoom.service;

import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Statistics;
import com.example.CinemaRoom.model.Ticket;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class StatisticsService {

    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;
    private Statistics statistics;

    @Autowired
    public void CinemaRoomApplication(SeatRepository seatRepository,TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    private void generateStatistics() {
        generateAvailable();
        List<Seat> seatList = new ArrayList<>();
        List<Ticket> ticketList = ticketRepository.findAll();
        for (Ticket ticket : ticketList) {
            seatList.add(seatRepository.findById((ticket.getSeat())).get());
        }
        seatList.forEach(seat -> {
            statistics = new Statistics(statistics.income() + 1,
                    statistics.available() - 1, statistics.purchased() + seat.getPrice());
        });
    }

    private void generateAvailable() {
        statistics =  new Statistics(seatRepository.findAll().size());
    }

    public Statistics getStatistic() {
        generateStatistics();
        return statistics;
    }

}
