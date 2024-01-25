package com.example.CinemaRoom.model;

import com.example.CinemaRoom.dto.SeatResponse;

public record Ticket (String token, SeatResponse ticket) {}
