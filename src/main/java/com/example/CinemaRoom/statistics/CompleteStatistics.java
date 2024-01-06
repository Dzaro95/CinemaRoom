package com.example.CinemaRoom.statistics;

import com.example.CinemaRoom.seat.SeatsInCinema;

public class CompleteStatistics {
    private Statistics statistics = new Statistics(SeatsInCinema.numberOfSeatsInCinema());

    public CompleteStatistics() {
    }

    public void addSoldTicket(int income) {
        statistics.addSoldTicket(income);
    }
    public void returnTicket(int income) {
        statistics.returnTicket(income);
    }
    public Statistics getStatistics() {
        return statistics;
    }

}
