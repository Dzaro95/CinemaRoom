package com.example.CinemaRoom.repository;

import com.example.CinemaRoom.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findSeatByRowAndColumn(Integer row, Integer column);
}
