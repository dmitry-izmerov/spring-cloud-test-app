package ru.demi.services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.demi.services.reservation.domain.Room;

import java.util.List;

@RestController
public class RoomReservationController {

    private final RestTemplate restTemplate;

    @Autowired
    public RoomReservationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        ResponseEntity<List<Room>> response = restTemplate.exchange("http://ROOMSERVICES/rooms", HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {});
        return response.getBody();
    }
}
