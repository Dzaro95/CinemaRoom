package com.example.CinemaRoom.repository;

import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats, Long> {
}
