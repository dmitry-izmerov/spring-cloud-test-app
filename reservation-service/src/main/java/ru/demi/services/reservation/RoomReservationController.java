package ru.demi.services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.demi.services.reservation.client.RoomService;
import ru.demi.services.reservation.domain.Room;

import java.util.List;

@RestController
public class RoomReservationController {

    private final RoomService roomService;

    @Autowired
    public RoomReservationController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.findAll(null);
    }
}
