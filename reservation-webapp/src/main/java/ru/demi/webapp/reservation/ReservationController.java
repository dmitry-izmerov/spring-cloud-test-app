package ru.demi.webapp.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import ru.demi.webapp.reservation.client.RoomReservationService;
import ru.demi.webapp.reservation.domain.RoomReservation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final RoomReservationService roomReservationService;

    @Autowired
    public ReservationController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        String date = dateString;
        if (StringUtils.isBlank(dateString)) {
            date = this.createTodayDateString();
        }
        List<RoomReservation> roomReservations = roomReservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }

    public String createTodayDateString() {
        return DATE_FORMAT.format(new Date());
    }
}