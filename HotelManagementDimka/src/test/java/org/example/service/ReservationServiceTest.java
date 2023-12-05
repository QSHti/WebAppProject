package org.example.service;

import org.example.entity.Reservation;
import org.example.repository.ReservationRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepo reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void shouldCreateReservation() {
        reservation = new Reservation();
        reservation.setGuestId(1L);
        reservation.setRoomId(101L);
        reservation.setCheckInDate(LocalDate.of(2023, 12, 20));
        reservation.setCheckOutDate(LocalDate.of(2023, 12, 25));
        reservation.setTotalPrice(500);

        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);
    }

    @Test
    void findReservationById() {
    }

    @Test
    void deleteReservation() {
    }
}