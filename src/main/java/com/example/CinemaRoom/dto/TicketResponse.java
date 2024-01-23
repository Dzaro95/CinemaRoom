package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;

public record TicketResponse(String token, Seat ticket) {}
