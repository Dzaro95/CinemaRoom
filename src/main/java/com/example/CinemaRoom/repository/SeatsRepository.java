package com.example.CinemaRoom.repository;

//import com.example.CinemaRoom.model.Seat;
//import com.example.CinemaRoom.model.Seats;
import com.example.CinemaRoom.model.Seat;
import com.example.CinemaRoom.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Long> {
    @Query("from PData where data_id = ?1")
    List<Seat> findByKey(String data_id);
}
