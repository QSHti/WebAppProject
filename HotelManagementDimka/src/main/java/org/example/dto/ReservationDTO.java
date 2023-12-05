package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {
    private Long guestId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
