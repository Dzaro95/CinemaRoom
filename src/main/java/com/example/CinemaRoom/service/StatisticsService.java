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
    private final int STATISTIC_ID = 1;
    private final int ONE_TICKET = 1;

    public void registerPurchase(int income) {
        Optional<Statistics> statistics = statisticRepository.findById(STATISTIC_ID);
        Statistics existingSeat = statistics.get();
        existingSeat.setIncome(existingSeat.getIncome() + income);
        existingSeat.setAvailable(existingSeat.getAvailable() - ONE_TICKET);
        existingSeat.setPurchased(existingSeat.getPurchased() + ONE_TICKET);
        statisticRepository.save(existingSeat);
    }

    public void registerReturn(int income) {
        Optional<Statistics> statistics = statisticRepository.findById(STATISTIC_ID);
        Statistics existingSeat = statistics.get();
        existingSeat.setIncome(existingSeat.getIncome() - income);
        existingSeat.setAvailable(existingSeat.getAvailable() + ONE_TICKET);
        existingSeat.setPurchased(existingSeat.getPurchased() - ONE_TICKET);
        statisticRepository.save(existingSeat);
    }

    public List<StatisticsResponse> getStatistic() {
        return statisticRepository.findById(STATISTIC_ID).stream().map(statistics -> new StatisticsResponse(statistics.getIncome(),
                statistics.getAvailable(),statistics.getPurchased())).collect(Collectors.toList());
    }
}
