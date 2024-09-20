package com.bench.MayorMaven.repo;

import com.bench.MayorMaven.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepo extends JpaRepository<Reservation, Integer> {
}
