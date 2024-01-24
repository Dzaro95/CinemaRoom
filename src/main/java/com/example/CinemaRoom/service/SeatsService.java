package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatDTO;
import com.example.CinemaRoom.dto.SeatsDTO;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class SeatsService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SeatRepository seatRepository;
    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int PREMIUM_ROWS = 4;
    private static final int PREMIUM_PRICE = 10;
    private static final int STANDARD_PRICE = 8;
    private List<Seat> seats = new ArrayList<>();

    public Seat findSeat(int row, int column) {
        Seat seat = new Seat(row, column, getPriceForRow(row));
        if (seats.contains(seat)) {
            return seat;
        } else {
            throw new PurchaseException("The number of a row or a column is out of bounds!");
        }
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public int numberOfSeats() {
        return ROWS * COLUMNS;
    }

    private int getPriceForRow(int row) {
        return row <= PREMIUM_ROWS ? PREMIUM_PRICE : STANDARD_PRICE;
    }

    public SeatsDTO convertSeatsToDTO(Seats seats) {
        SeatsDTO dto = modelMapper.map(seats, SeatsDTO.class);
        return dto;
    }

    public List<Seat> getAllSeatTest(){
        return seatRepository.findAll();
    }

    public SeatsDTO covertSeatsToDTO(Seats seats) {
        List<SeatDTO> seatDTO = seatRepository.findAll().stream()
                .map(seat -> new SeatDTO(seat.getRow(), seat.getColumn(), seat.getPrice())).collect(Collectors.toList());
        SeatsDTO dto = new SeatsDTO(seats.getROWS(), seats.getCOLUMNS(),seatDTO);
        return dto;
    }

    public Seats converteDTOToSeats(SeatsDTO seatsDTO) {
        Seats seats = new Seats();
        return seats;
    }

}
