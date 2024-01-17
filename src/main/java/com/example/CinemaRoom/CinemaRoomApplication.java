package com.example.CinemaRoom;

//import com.example.CinemaRoom.model.Seats;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaRoomApplication {
	/*
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	 */

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
	}
	/*
	@Autowired
	SeatsRepository seatsRepository;
	@Override
	public void run(String... args) throws Exception {
		SeatsInformation seatsInformation = new SeatsInformation();
		Seats seats = new Seats();
		seats.setRows(seatsInformation.ROWS);
		seats.setColumns(seatsInformation.COLUMNS);
		//seats.setSeats(seatsInformation.getSEATS().get(0));
		seatsRepository.save(seats);
	}

	 */
}
