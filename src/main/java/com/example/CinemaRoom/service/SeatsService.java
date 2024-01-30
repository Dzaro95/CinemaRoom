package com.example.CinemaRoom.service;

import com.example.CinemaRoom.dto.SeatResponse;
import com.example.CinemaRoom.dto.SeatsResponse;
import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.SeatsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
    @Autowired
    private SeatsRepository seatsRepository;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int PREMIUM_ROWS = 4;
    private static final int PREMIUM_PRICE = 10;
    private static final int STANDARD_PRICE = 8;
    private List<SeatResponse> seats = new ArrayList<>();

    public SeatResponse findSeat(int row, int column) {
        System.out.println(seats.isEmpty());
        checkSeatsDTOList();
        SeatResponse seat = new SeatResponse(row, column, getPriceForRow(row));
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

    public SeatsResponse convertSeatsToDTO(Seats seats) {
        SeatsResponse dto = modelMapper.map(seats, SeatsResponse.class);
        return dto;
    }

    public List<Seat> getAllSeatTest(){
        return seatRepository.findAll();
    }

    public List<Seats> getAllSeatsTest(){
        return seatsRepository.findAll();
    }

    public SeatsResponse covertSeatsToDTO() {
        Seats seats = seatsRepository.findAll().stream().findFirst().get();
        List<SeatResponse> seatResponse = seatRepository.findAll().stream()
                .map(seat -> new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice())).collect(Collectors.toList());
        SeatsResponse seatsResponse = new SeatsResponse(seats.getROWS(), seats.getCOLUMNS(), seatResponse);
        return seatsResponse;
    }

    public List<SeatResponse> fillSeats() {
        List<SeatResponse> seatResponse = new ArrayList<>();
        try {
            seatResponse = seatRepository.findAll().stream()
                    .map(seat -> new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice())).collect(Collectors.toList());
            return seatResponse;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return seatResponse;
    }

    public Seats converteDTOToSeats(SeatsResponse seatsResponse) {
        Seats seats = new Seats();
        return seats;
    }



    private void checkSeatsDTOList() {
        if(seats.isEmpty()) {
            seats = seatRepository.findAll().stream()
                    .map(seat -> new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice())).collect(Collectors.toList());
        }
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

}
