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

    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> findReservationByGuestId(Long guestId) {
        return reservationRepository.findByGuestId(guestId);
    }

    public Reservation updateReservation(Long id, Reservation reservation){
        Optional<Reservation> reservationToUpdate = reservationRepository.findById(id);
        if (reservationToUpdate.isPresent()) {
            Reservation updatedReservation = reservationToUpdate.get();
            updatedReservation.setCheckInDate(reservation.getCheckInDate());
            updatedReservation.setCheckOutDate(reservation.getCheckOutDate());
            updatedReservation.setGuestId(reservation.getGuestId());
            updatedReservation.setRoomId(reservation.getRoomId());
            updatedReservation.setTotalPrice(reservation.getTotalPrice());
            return reservationRepository.save(updatedReservation);
        }
        return null;
    }

}
