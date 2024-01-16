package com.example.CinemaRoom.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "ticket")
public record Ticket (String token, Seat ticket) { }
