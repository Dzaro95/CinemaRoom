package com.example.CinemaRoom.repository;

//import com.example.CinemaRoom.model.Seat;
//import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.service.SeatsInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<SeatsInformation, Long> {
}
