package org.example.repository;

import org.example.entity.Reservation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long> {
    List<Reservation> findByGuestId(Long guestId);

    List<Reservation> findReservationByGuestId(Long guestId);
}

