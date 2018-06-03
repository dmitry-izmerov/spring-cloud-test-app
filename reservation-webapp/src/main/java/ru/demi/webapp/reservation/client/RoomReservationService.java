package ru.demi.webapp.reservation.client;

import ru.demi.webapp.reservation.domain.Room;
import ru.demi.webapp.reservation.domain.RoomReservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("RESERVATION-BUSINESS-SERVICE")
public interface RoomReservationService {

    @GetMapping("/rooms")
    List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber);

    @GetMapping("/roomReservations/{date}")
    List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date);
}
