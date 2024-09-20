package com.bench.MayorMaven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservation")
public class Reservation {
    @Id
    private Long id;
    private String reservation;
    private LocalDateTime initTime;
    private LocalDateTime endTime;

}
