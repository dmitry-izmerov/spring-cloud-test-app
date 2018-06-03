package ru.demi.services.reservation;

import lombok.Data;

@Data
public class Reservation {
    private long id;
    private long roomId;
    private long guestId;
    private String reservationDate;
}
