package com.example.CinemaRoom;

import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import com.example.CinemaRoom.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaRoomApplication implements CommandLineRunner {

	@Autowired
	private final SeatRepository seatRepository;

	@Autowired
	private final TicketRepository ticketRepository;

	@Autowired
	private SeatsService seatsService;

	@Autowired
	public CinemaRoomApplication(SeatRepository seatRepository, TicketRepository ticketRepository) {
		this.seatRepository = seatRepository;
		this.ticketRepository = ticketRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (seatRepository.findAll().isEmpty()) {
			seatsService.generateSeats();
		}
	}
}
