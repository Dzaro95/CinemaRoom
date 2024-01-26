package com.example.CinemaRoom;

import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.SeatsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.CinemaRoom.Function.Function.seatList;

@SpringBootApplication
public class CinemaRoomApplication implements CommandLineRunner {

	@Autowired
	private final SeatsRepository seatsRepository;
	@Autowired
	private final SeatRepository seatRepository;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public CinemaRoomApplication(SeatsRepository seatsRepository, SeatRepository seatRepository){
		this.seatsRepository = seatsRepository;
		this.seatRepository = seatRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!seatRepository.existsById(1)) {
			Seats seats = new Seats();
			seats.setSEATS(seatList(seats.getROWS(), seats.getCOLUMNS()));
			seatsRepository.save(seats);
		}
	}
}
