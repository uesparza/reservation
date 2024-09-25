package com.bench.MayorMaven.service;

import com.bench.MayorMaven.model.Reservation;
import com.bench.MayorMaven.repo.IReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.time.Duration;

@Service
public class ReservationService {

    @Autowired
    private IReservationRepo iReservationRepo;

    public Reservation save(Reservation reservation) {
        return iReservationRepo.save(reservation);
    }


    public int findLargestGapInHours() {

        List<Reservation> reservations = iReservationRepo.findAll();
        reservations.sort((r1, r2) -> r1.getInitTime().compareTo(r2.getInitTime()));

        int largestGapInHours = 0;
        for (int i = 0; i < reservations.size() - 1; i++) {
            LocalDateTime endCurrent = reservations.get(i).getEndTime();
            LocalDateTime startNext = reservations.get(i + 1).getInitTime();
            Duration duration = Duration.between(endCurrent, startNext);
            if (duration.isNegative()) {
                continue;
            }
            int gapInHours = (int) duration.toHours();
            if (gapInHours > largestGapInHours)
                largestGapInHours = gapInHours;
        }
        return largestGapInHours;
    }

    public String findLargestGapInString() {

        List<Reservation> reservations = iReservationRepo.findAll();
        reservations.sort((r1, r2) -> r1.getInitTime().compareTo(r2.getInitTime()));

        int largestGapInHours = 0;
        String str = "";
        for (int i = 0; i < reservations.size() - 1; i++) {
            LocalDateTime endCurrent = reservations.get(i).getEndTime();
            LocalDateTime startNext = reservations.get(i + 1).getInitTime();
            Duration duration = Duration.between(endCurrent, startNext);
            if (duration.isNegative()) {
                continue;
            }
            int gapInHours = (int) duration.toHours();
            if (gapInHours > largestGapInHours) {
                largestGapInHours = gapInHours;
                str = "{current:"+endCurrent+",next:"+startNext+"}";
            }
        }
        return str;
    }

    public void delete(Reservation reservation) {
        iReservationRepo.delete(reservation);
    }

}