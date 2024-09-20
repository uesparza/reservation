package com.bench.MayorMaven.controller;

import com.bench.MayorMaven.model.Reservation;
import com.bench.MayorMaven.repo.IReservationRepo;
import com.bench.MayorMaven.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Reservations")
public class MayorReservation {

    @Autowired
    private ReservationService ReservationService;

    @GetMapping("/mayor")
    public Integer greeting() {
        return ReservationService.findLargestGapInHours();
    }

    @PostMapping("/save")
    public String save(@RequestBody Reservation reservation) {
        ReservationService.save(reservation);
        return "saved";
    }


}
