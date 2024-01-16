package com.example.CinemaRoom;

import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatsRepository;
import com.example.CinemaRoom.service.SeatsInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CinemaRoomApplication implements CommandLineRunner {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
	}
	@Autowired
	SeatsRepository seatsRepository;
	@Override
	public void run(String... args) throws Exception {
		SeatsInformation seatsInformation = new SeatsInformation();
		Seats seats = new Seats();
		seats.setId(1);
		seats.setRows(seatsInformation.ROWS);
		seats.setColumns(seatsInformation.COLUMNS);
		seats.setSeat(seatsInformation.getSEATS());
		seatsRepository.save(seats);
	}
}
