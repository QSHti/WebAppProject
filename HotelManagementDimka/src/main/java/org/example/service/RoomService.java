package org.example.service;

import lombok.Setter;
import org.example.entity.Room;
import org.example.repository.RoomRepo;
import org.springframework.stereotype.Service;

@Service
@Setter
public class RoomService {
    private final RoomRepo roomRepository;

    public RoomService(RoomRepo roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    /*public Iterable<Room> getAvailableRooms(boolean isAvailable) {
        return roomRepository.findByIsAvailable(isAvailable);
    }

     */
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
