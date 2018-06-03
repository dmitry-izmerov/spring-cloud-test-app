package ru.demi.services.business.reservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.demi.services.business.reservation.domain.Reservation;

import java.util.List;

@FeignClient("RESERVATIONSERVICES")
public interface ReservationService {

    @GetMapping("/reservations")
    List<Reservation> findAll(@RequestParam(name = "date", required = false) String date);
}