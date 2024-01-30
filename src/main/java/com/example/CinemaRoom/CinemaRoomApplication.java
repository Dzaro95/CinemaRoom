package com.example.CinemaRoom;

import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Statistics;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.SeatsRepository;
import com.example.CinemaRoom.repository.StatisticRepository;
import com.example.CinemaRoom.repository.TicketRepository;
import com.example.CinemaRoom.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaRoomApplication implements CommandLineRunner {

	@Autowired
	private final SeatsRepository seatsRepository;
	@Autowired
	private final SeatRepository seatRepository;
	@Autowired
	private final TicketRepository ticketRepository;
	@Autowired
	private final StatisticRepository statisticRepository;
	@Autowired
	private SeatsService seatsService;

	public CinemaRoomApplication(SeatsRepository seatsRepository, SeatRepository seatRepository,
								 TicketRepository ticketRepository,
								 StatisticRepository statisticRepository) {
		this.seatsRepository = seatsRepository;
		this.seatRepository = seatRepository;
		this.ticketRepository = ticketRepository;
		this.statisticRepository = statisticRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (seatRepository.findAll().isEmpty()) {
			Statistics statistics = new Statistics();
			Seats seats = new Seats();
			seats.setSEATS(seatsService.seatList());
			statistics.setAvailable(seats.getSEATS().size());
			seatsRepository.save(seats);
			statisticRepository.save(statistics);
		}
	}
}
