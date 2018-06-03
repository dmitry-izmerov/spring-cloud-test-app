package ru.demi.services.business.reservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.demi.services.business.reservation.domain.Guest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("GUESTSERVICES")
public interface GuestService {

    @GetMapping("/guests")
    List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress);

    @GetMapping("/guests/{id}")
    Guest findOne(@PathVariable(name = "id") long id);
}
