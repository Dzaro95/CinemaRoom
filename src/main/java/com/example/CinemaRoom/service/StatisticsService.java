package com.example.CinemaRoom.service;

import com.example.CinemaRoom.statistics.Statistics;

public class StatisticsService {
    private Statistics statistics = new Statistics(SeatsService.numberOfSeatsInCinema());

    public StatisticsService() {
    }

    public void addPurchasedTicket(int income) {
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
