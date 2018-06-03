package ru.demi.services.guest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/guests")
@Api(value = "guests", description = "Data service operations on guests", tags = ("guests"))
public class GuestController {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    @ApiOperation(value = "Get All Guests", notes = "Gets all guests in the system", nickname = "getGuests")
    public List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress) {
        if (StringUtils.isNotBlank(emailAddress)) {
            return Collections.singletonList(guestRepository.findByEmailAddress(emailAddress));
        }
        return guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest findOne(@PathVariable(name = "id") long id) {
        return guestRepository.findById(id).orElse(null);
    }
}
