package ru.demi.services.business.reservation;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.demi.services.business.reservation.client.RoomService;
import ru.demi.services.business.reservation.domain.Room;
import ru.demi.services.business.reservation.domain.RoomReservation;

import java.util.List;

@RestController
public class RoomReservationController {

    private final RoomService roomService;

    private final RoomReservationBusinessProcess businessProcess;

    @Autowired
    public RoomReservationController(RoomService roomService, RoomReservationBusinessProcess businessProcess) {
        this.roomService = roomService;
        this.businessProcess = businessProcess;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        return this.roomService.findAll(roomNumber);
    }

    @RequestMapping(value = "/roomReservations/{date}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Room Reservations", notes = "Gets all reservations for a specific date", nickname = "getReservationsForDate")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date) {
        return this.businessProcess.getRoomReservationsForDate(date);
    }
}
