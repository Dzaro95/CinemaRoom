package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.StatisticsResponse;
import com.example.CinemaRoom.model.Statistics;
import com.example.CinemaRoom.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    @Autowired
    private StatisticRepository statisticRepository;

    public void registerPurchase(int income) {
        Optional<Statistics> statistics = statisticRepository.findById(1);
        Statistics existingSeat = statistics.get();
        existingSeat.setIncome(existingSeat.getIncome() + income);
        existingSeat.setAvailable(existingSeat.getAvailable() - 1);
        existingSeat.setPurchased(existingSeat.getPurchased() + 1);
        statisticRepository.save(existingSeat);
    }

    public void registerReturn(int income) {
        Optional<Statistics> statistics = statisticRepository.findById(1);
        Statistics existingSeat = statistics.get();
        existingSeat.setIncome(existingSeat.getIncome() - income);
        existingSeat.setAvailable(existingSeat.getAvailable() + 1);
        existingSeat.setPurchased(existingSeat.getPurchased() - 1);
        statisticRepository.save(existingSeat);
    }

    public Statistics getStatistic() {
        return statisticRepository.findAll().get(0);
    }

}
