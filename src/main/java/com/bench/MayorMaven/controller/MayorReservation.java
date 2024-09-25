package com.bench.MayorMaven.controller;

import com.bench.MayorMaven.model.Reservation;
import com.bench.MayorMaven.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Reservations")
public class MayorReservation {

    @Autowired
    private ReservationService ReservationService;

    @GetMapping("/mayor")
    public Integer mayor() {
        return ReservationService.findLargestGapInHours();
    }

    @GetMapping("/mayorDates")
    public String mayorDa() {
        return ReservationService.findLargestGapInString();
    }

    @PostMapping("/save")
    public String save(@RequestBody Reservation reservation) {
        ReservationService.save(reservation);
        return "saved";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Reservation reservation) {
        ReservationService.delete(reservation);
        return "deleted";
    }


}
