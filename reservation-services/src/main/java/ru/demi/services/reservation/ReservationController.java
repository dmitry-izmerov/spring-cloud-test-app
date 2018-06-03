package ru.demi.services.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import ru.demi.services.reservation.utils.DateTimeUtils;
import ru.demi.services.reservation.utils.ReservationTranslator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
@Api(value = "reservations", description = "Data service operations on reservations", tags = ("reservations"))
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final DateTimeUtils dateTimeUtils;
    private final ReservationTranslator reservationTranslator;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, DateTimeUtils dateTimeUtils, ReservationTranslator reservationTranslator) {
        this.reservationRepository = reservationRepository;
        this.dateTimeUtils = dateTimeUtils;
        this.reservationTranslator = reservationTranslator;
    }

    @GetMapping
    @ApiOperation(value = "Get All Reservations", notes = "Gets all reservations in the system", nickname = "getReservations")
    public List<Reservation> findAll(@RequestParam(name = "date", required = false) String date) {
        List<ReservationEntity> entities = null;
        if (StringUtils.isNotBlank(date)) {
            entities = this.reservationRepository.findByDate(this.dateTimeUtils.createDateFromDateString(date));
        } else {
            entities = (List<ReservationEntity>) this.reservationRepository.findAll();
        }
        List<Reservation> reservations = new ArrayList<>(entities.size());
        entities.forEach(entity -> {
            reservations.add(this.reservationTranslator.translateEntityToReservation(entity));
        });
        return reservations;
    }
}
