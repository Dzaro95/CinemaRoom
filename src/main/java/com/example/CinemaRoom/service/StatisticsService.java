package com.example.CinemaRoom.service;

import com.example.CinemaRoom.model.Statistics;

public class StatisticsService {
    private Statistics statistics;
    public StatisticsService(int available) {
        this.statistics = new Statistics(available);
    }
    public Statistics registerPurchase(Statistics statistics, int income) {
        return new Statistics(statistics.income() + income,
                statistics.available() - 1,
                statistics.purchased() + 1);
    }
    public Statistics registerReturn(Statistics statistics, int income) {
        return new Statistics(statistics.income() - income,
                statistics.available() + 1,
                statistics.purchased() - 1);
    }
    public Statistics getStatistics() {
        return statistics;
    }
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
