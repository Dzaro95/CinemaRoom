package com.example.CinemaRoom.model;

import com.example.CinemaRoom.exception.PurchaseException;
import com.example.CinemaRoom.service.SeatsService;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public record Seat(int row, int column, int price) {}




