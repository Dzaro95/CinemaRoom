package com.example.CinemaRoom.service;

//import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.dto.SeatDTO;
import com.example.CinemaRoom.dto.SeatsDTO;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.SeatsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {
    @Autowired
    private final SeatsRepository seatsRepository;
    @Autowired
    private final SeatRepository seatRepository;


    @Autowired
    private ModelMapper modelMapper;

    public SeatsDTO convertSeatsToDTO(Seats seats) {
        SeatsDTO dto = modelMapper.map(seats, SeatsDTO.class);
        return dto;
    }

    public List<Seat>  getAllSeatTest(){

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
    public List<SeatDTO> seatList(){
        List<SeatDTO> seatList = new ArrayList<>();
        for (int row = 1; row <= 9; row++) {
            for (int column = 1; column <= 9; column++) {
                SeatDTO seat = new SeatDTO(row,column,row <= 4 ? 10 : 8);
                seatList.add(seat);
            }
        }
        return seatList;
    }




}

