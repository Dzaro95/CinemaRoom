package com.example.CinemaRoom.statistics;

import com.example.CinemaRoom.seat.SeatsInCinema;

public class CompleteStatistics {
    private Statistics statistics = new Statistics(SeatsInCinema.numberOfSeatsInCinema());

    public CompleteStatistics() {
    }

    public void addSoldTicket(int income) {
        statistics.setIncome(statistics.getIncome() + income);
        statistics.setAvailable(statistics.getAvailable() - 1);
        statistics.setPurchased(statistics.getPurchased() + 1);

    }
    public void returnTicket(int income) {
        statistics.setIncome(statistics.getIncome() - income);
        statistics.setAvailable(statistics.getAvailable() + 1);
        statistics.setPurchased(statistics.getPurchased() - 1);
    }
    public Statistics getStatistics() {
        return statistics;
    }
}
