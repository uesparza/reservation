package com.bench.MayorMaven.controller;

import com.bench.MayorMaven.model.Reservation;
import com.bench.MayorMaven.repo.IReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MayorReservation {

    @Autowired
    private IReservationRepo iReservationRepo;

    @GetMapping("/greeting")
    public String greeting() {

        Reservation reservation = new Reservation();

        iReservationRepo.save(reservation);
        return "hola mundo";
    }


}
