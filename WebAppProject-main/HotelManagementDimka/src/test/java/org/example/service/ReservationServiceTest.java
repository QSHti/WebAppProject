package org.example.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.entity.Reservation;
import org.example.repository.ReservationRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReservationService.class})
@ExtendWith(SpringExtension.class)
class ReservationServiceTest {
  @MockBean
  private ReservationRepo reservationRepo;

  @Autowired
  private ReservationService reservationService;

  /**
   * Method under test: {@link ReservationService#createReservation(Reservation)}
   */
  @Test
  void testCreateReservation() {
    Reservation buildResult = Reservation.builder().guestId(1L).id(1L).roomId(1L).totalPrice(10.0d).build();
    when(reservationRepo.save(Mockito.<Reservation>any())).thenReturn(buildResult);
    reservationService.createReservation(null);
    verify(reservationRepo).save(Mockito.<Reservation>any());
  }

  /**
   * Method under test: {@link ReservationService#getAllReservations()}
   */
  @Test
  void testGetAllReservations() {
    ArrayList<Reservation> reservationList = new ArrayList<>();
    when(reservationRepo.findAll()).thenReturn(reservationList);
    List<Reservation> actualAllReservations = reservationService.getAllReservations();
    verify(reservationRepo).findAll();
    assertTrue(actualAllReservations.isEmpty());
    assertSame(reservationList, actualAllReservations);
  }

  /**
   * Method under test: {@link ReservationService#findReservationById(Long)}
   */
  @Test
  void testFindReservationById() {
    Reservation buildResult = Reservation.builder().guestId(1L).id(1L).roomId(1L).totalPrice(10.0d).build();
    Optional<Reservation> ofResult = Optional.of(buildResult);
    when(reservationRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
    Optional<Reservation> actualFindReservationByIdResult = reservationService.findReservationById(1L);
    verify(reservationRepo).findById(Mockito.<Long>any());
    assertTrue(actualFindReservationByIdResult.isPresent());
    assertSame(ofResult, actualFindReservationByIdResult);
  }

  /**
   * Method under test: {@link ReservationService#deleteReservation(Long)}
   */
  @Test
  void testDeleteReservation() {
    doNothing().when(reservationRepo).deleteById(Mockito.<Long>any());
    reservationService.deleteReservation(1L);
    verify(reservationRepo).deleteById(Mockito.<Long>any());
  }

  /**
   * Method under test: {@link ReservationService#findReservationByGuestId(Long)}
   */
  @Test
  void testFindReservationByGuestId() {
    ArrayList<Reservation> reservationList = new ArrayList<>();
    when(reservationRepo.findByGuestId(Mockito.<Long>any())).thenReturn(reservationList);
    List<Reservation> actualFindReservationByGuestIdResult = reservationService.findReservationByGuestId(1L);
    verify(reservationRepo).findByGuestId(Mockito.<Long>any());
    assertTrue(actualFindReservationByGuestIdResult.isEmpty());
    assertSame(reservationList, actualFindReservationByGuestIdResult);
  }

  /**
   * Method under test:
   * {@link ReservationService#updateReservation(Long, Reservation)}
   */
  @Test
  void testUpdateReservation() {
    Optional<Reservation> emptyResult = Optional.empty();
    when(reservationRepo.findById(Mockito.<Long>any())).thenReturn(emptyResult);
    Reservation actualUpdateReservationResult = reservationService.updateReservation(1L, null);
    verify(reservationRepo).findById(Mockito.<Long>any());
    assertNull(actualUpdateReservationResult);
  }

  /**
   * Method under test:
   * {@link ReservationService#updateReservation(Long, Reservation)}
   */
  @Test
  void testUpdateReservation2() {
    Reservation buildResult = Reservation.builder().guestId(1L).id(1L).roomId(1L).totalPrice(10.0d).build();
    when(reservationRepo.save(Mockito.<Reservation>any())).thenReturn(buildResult);
    Reservation buildResult2 = Reservation.builder().guestId(1L).id(1L).roomId(1L).totalPrice(10.0d).build();
    Optional<Reservation> ofResult = Optional.of(buildResult2);
    when(reservationRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
    Reservation reservation = Reservation.builder().guestId(1L).id(1L).roomId(1L).totalPrice(10.0d).build();
    reservationService.updateReservation(1L, reservation);
    verify(reservationRepo).findById(Mockito.<Long>any());
    verify(reservationRepo).save(Mockito.<Reservation>any());
  }
}
