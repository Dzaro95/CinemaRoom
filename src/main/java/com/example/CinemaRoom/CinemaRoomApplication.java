package com.example.CinemaRoom;

import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Statistics;
import com.example.CinemaRoom.repository.SeatRepository;
import com.example.CinemaRoom.repository.SeatsRepository;
import com.example.CinemaRoom.repository.StatisticRepository;
import com.example.CinemaRoom.repository.TicketRepository;
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
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private StatisticRepository statisticRepository;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

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
		if (!seatRepository.existsById(1)) {
			Statistics statistics = new Statistics();
			Seats seats = new Seats();
			seats.setSEATS(seatList(seats.getROWS(), seats.getCOLUMNS()));
			statistics.setAvailable(seats.getSEATS().size());
			seatsRepository.save(seats);
			statisticRepository.save(statistics);
		}
	}
}
