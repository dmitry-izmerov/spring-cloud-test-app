package ru.demi.services.reservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.demi.services.reservation.domain.Room;

import java.util.List;

@FeignClient("ROOMSERVICES")
public interface RoomService {

    @GetMapping("/rooms")
    List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber);
}
