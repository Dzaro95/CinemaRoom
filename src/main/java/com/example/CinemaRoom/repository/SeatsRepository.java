package com.example.CinemaRoom.repository;

import com.example.CinemaRoom.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seat, Long> {
}
