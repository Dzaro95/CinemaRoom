package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.dto.SeatsResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.repository.SeatRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class SeatsService {

    @Autowired
    private SeatRepository seatRepository;
    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int PREMIUM_ROWS = 4;
    private static final int PREMIUM_PRICE = 10;
    private static final int STANDARD_PRICE = 8;

    public SeatsResponse getSeats() {
        return convertSeatToSeatsResponse();
    }

    public SeatsResponse convertSeatToSeatsResponse() {
        List<SeatResponse> seatResponse = seatRepository.findAll().stream()
                .map(seat -> new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice())).collect(Collectors.toList());
        SeatsResponse seatsResponse = new SeatsResponse(ROWS, COLUMNS, seatResponse);
        return seatsResponse;
    }

    public Seat findSeatByRowAndColumn(int row, int column) {
        if(seatRepository.findSeatByRowAndColumn(row, column).isEmpty()) {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
        else {
            List<Seat> seat = seatRepository.findSeatByRowAndColumn(row, column);
            return seat.get(0);
        }
    }

    public void generateSeats() {
        for (int row = 1; row <= ROWS; row++) {
            for (int column = 1; column <= COLUMNS; column++) {
                Seat seat = new Seat();
                seat.setRow(row);
                seat.setColumn(column);
                seat.setPrice(row <= PREMIUM_ROWS ? PREMIUM_PRICE : STANDARD_PRICE);
                seatRepository.save(seat);
            }
        }
    }
}
