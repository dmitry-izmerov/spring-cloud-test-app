package ru.demi.services.room;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Api(value = "rooms", description = "Data service operations on rooms", tags = "rooms")
@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @ApiOperation(value = "Get all rooms", notes = "Get all rooms in the system", nickname = "getRooms")
    @GetMapping
    public List<Room> getAll(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isNotEmpty(roomNumber)) {
            return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
        }
        return roomRepository.findAll();
    }
}
