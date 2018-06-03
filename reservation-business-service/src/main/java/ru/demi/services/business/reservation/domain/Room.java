package ru.demi.services.business.reservation.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    private Long id;
    private String name;
    private String roomNumber;
    private String bedInfo;
}
