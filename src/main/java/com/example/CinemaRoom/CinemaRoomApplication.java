package com.example.CinemaRoom;

//import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.repository.SeatsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	private SeatsRepository seatsRepository;
	@Override
	public void run(String... args) throws Exception {

		Seats seats = new Seats();

		seatsRepository.save();
	}


}
