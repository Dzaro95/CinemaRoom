package com.example.CinemaRoom.service;

import com.example.CinemaRoom.model.Statistics;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private Statistics statistics;
/*
    public StatisticsService(int available) {
        this.statistics = new Statistics(available);
    }

    public void registerPurchase(int income) {
       statistics =  new Statistics(statistics.getIncome() + income,
                statistics.getAvailable() - 1,
                statistics.getPurchased() + 1);
    }

    public void registerReturn(int income) {
        statistics = new Statistics(statistics.income() - income,
                statistics.available() + 1,
                statistics.purchased() - 1);
    }

 */

    public Statistics getStatistics() {
        return statistics;
    }
}
