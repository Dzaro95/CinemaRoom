package com.example.CinemaRoom.service;

//import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.dto.SeatsDTO;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {
    @Autowired
    private final SeatsRepository seatsRepository;

    @Autowired
    private ModelMapper modelMapper;



    public List<Seats> getAllSeat(){
        return seatsRepository.findAll();
        /*
        return seatsRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

         */


    }


/*
    private SeatsDTO convertEntityToDto(Seats seats){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SeatsDTO seatsDTO = new SeatsDTO(seats.getROWS(), seats.getCOLUMNS());
        seatsDTO = modelMapper.map(seats, SeatsDTO.class);
        return seatsDTO;
    }
    private Seats convertDtoToEntity(SeatsDTO seatsDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Seats seats = new Seats();
        seats = modelMapper.map(seatsDTO, Seats.class);
        return seats;
    }

 */


}

