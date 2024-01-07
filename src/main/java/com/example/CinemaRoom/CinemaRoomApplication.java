package com.example.CinemaRoom;

import com.example.CinemaRoom.seat.SeatsInCinema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaRoomApplication.class, args);
		SeatsInCinema.seats();
	}

}