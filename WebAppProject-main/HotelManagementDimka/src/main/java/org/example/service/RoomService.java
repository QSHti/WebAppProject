package org.example.service;

import lombok.Setter;
import org.example.entity.Reservation;
import org.example.entity.Room;
import org.example.repository.ReservationRepo;
import org.example.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
public class RoomService {

    @Autowired
    private final RoomRepo roomRepository;

    @Autowired
    private ReservationRepo reservationRepository;

    public RoomService(RoomRepo roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> reservations = (List<Reservation>)reservationRepository.findAll();
        List<Room> rooms = (List<Room>)roomRepository.findAll();
        List<Room> availableRooms = rooms.stream().filter(room -> {
            for (Reservation reservation : reservations) {
                if (reservation.getRoomId().equals(room.getId())) {
                    if((reservation.getCheckInDate().isBefore(checkOutDate) || reservation.getCheckInDate().isEqual(checkOutDate))
                            && (reservation.getCheckOutDate().isAfter(checkInDate) || reservation.getCheckOutDate().isEqual(checkInDate))){
                        return false;
                    }
                }
            }
            return true;
        }).collect(Collectors.toList());
        return availableRooms;
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
