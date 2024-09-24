package com.bench.MayorMaven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String reservation;
    private LocalDateTime initTime;
    private LocalDateTime endTime;

    public LocalDateTime getInitTime() {
        return initTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
