package com.example.CinemaRoom.repository;

import com.example.CinemaRoom.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    List<Ticket> findTicketBySeat(Integer seatID);
}
