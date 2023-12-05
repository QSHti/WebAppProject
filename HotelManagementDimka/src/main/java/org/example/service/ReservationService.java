package org.example.service;

import org.example.entity.Reservation;
import org.example.entity.Room;
import org.example.repository.ReservationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepository;

    public ReservationService(ReservationRepo reservationRepository) { this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
