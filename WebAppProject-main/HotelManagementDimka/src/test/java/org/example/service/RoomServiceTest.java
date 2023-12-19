package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.entity.Room;
import org.example.repository.ReservationRepo;
import org.example.repository.RoomRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoomService.class})
@ExtendWith(SpringExtension.class)
class RoomServiceTest {
  @MockBean
  private ReservationRepo reservationRepo;

  @MockBean
  private RoomRepo roomRepo;

  @Autowired
  private RoomService roomService;
  /**
   * Method under test: {@link RoomService#saveRoom(Room)}
   */
  @Test
  void testSaveRoom() {
    Room room = new Room();
    room.setId(1L);
    room.setPricePerNight(10.0d);
    room.setRoomNumber("42");
    room.setRoomType("Room Type");
    when(roomRepo.save(Mockito.<Room>any())).thenReturn(room);

    Room room2 = new Room();
    room2.setId(1L);
    room2.setPricePerNight(10.0d);
    room2.setRoomNumber("42");
    room2.setRoomType("Room Type");
    Room actualSaveRoomResult = roomService.saveRoom(room2);
    verify(roomRepo).save(Mockito.<Room>any());
    assertSame(room, actualSaveRoomResult);
  }

  /**
   * Method under test: {@link RoomService#getAllRooms()}
   */
  @Test
  void testGetAllRooms() {
    ArrayList<Room> roomList = new ArrayList<>();
    when(roomRepo.findAll()).thenReturn(roomList);
    List<Room> actualAllRooms = roomService.getAllRooms();
    verify(roomRepo).findAll();
    assertTrue(actualAllRooms.isEmpty());
    assertSame(roomList, actualAllRooms);
  }

  /**
   * Method under test:
   * {@link RoomService#getAvailableRooms(LocalDate, LocalDate)}
   */
  @Test
  void testGetAvailableRooms() {
    when(reservationRepo.findAll()).thenReturn(new ArrayList<>());
    when(roomRepo.findAll()).thenReturn(new ArrayList<>());
    LocalDate checkInDate = LocalDate.of(1970, 1, 1);
    List<Room> actualAvailableRooms = roomService.getAvailableRooms(checkInDate, LocalDate.of(1970, 1, 1));
    verify(reservationRepo).findAll();
    verify(roomRepo).findAll();
    assertTrue(actualAvailableRooms.isEmpty());
  }

  /**
   * Method under test:
   * {@link RoomService#getAvailableRooms(LocalDate, LocalDate)}
   */
  @Test
  void testGetAvailableRooms2() {
    when(reservationRepo.findAll()).thenReturn(new ArrayList<>());

    Room room = new Room();
    room.setId(1L);
    room.setPricePerNight(10.0d);
    room.setRoomNumber("42");
    room.setRoomType("Room Type");

    ArrayList<Room> roomList = new ArrayList<>();
    roomList.add(room);
    when(roomRepo.findAll()).thenReturn(roomList);
    LocalDate checkInDate = LocalDate.of(1970, 1, 1);
    List<Room> actualAvailableRooms = roomService.getAvailableRooms(checkInDate, LocalDate.of(1970, 1, 1));
    verify(reservationRepo).findAll();
    verify(roomRepo).findAll();
    assertEquals(1, actualAvailableRooms.size());
  }

  /**
   * Method under test:
   * {@link RoomService#getAvailableRooms(LocalDate, LocalDate)}
   */
  @Test
  void testGetAvailableRooms3() {
    when(reservationRepo.findAll()).thenReturn(new ArrayList<>());

    Room room = new Room();
    room.setId(1L);
    room.setPricePerNight(10.0d);
    room.setRoomNumber("42");
    room.setRoomType("Room Type");

    Room room2 = new Room();
    room2.setId(2L);
    room2.setPricePerNight(0.5d);
    room2.setRoomNumber("Room Number");
    room2.setRoomType("42");

    ArrayList<Room> roomList = new ArrayList<>();
    roomList.add(room2);
    roomList.add(room);
    when(roomRepo.findAll()).thenReturn(roomList);
    LocalDate checkInDate = LocalDate.of(1970, 1, 1);
    List<Room> actualAvailableRooms = roomService.getAvailableRooms(checkInDate, LocalDate.of(1970, 1, 1));
    verify(reservationRepo).findAll();
    verify(roomRepo).findAll();
    assertEquals(2, actualAvailableRooms.size());
  }

  /**
   * Method under test: {@link RoomService#deleteRoom(Long)}
   */
  @Test
  void testDeleteRoom() {
    doNothing().when(roomRepo).deleteById(Mockito.<Long>any());
    roomService.deleteRoom(1L);
    verify(roomRepo).deleteById(Mockito.<Long>any());
  }
}
