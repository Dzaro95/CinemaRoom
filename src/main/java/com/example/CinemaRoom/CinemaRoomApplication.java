package com.example.CinemaRoom;

import com.example.CinemaRoom.repository.SeatsRepository;
import com.example.CinemaRoom.service.SeatsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaRoomApplication {


	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
	}

}
