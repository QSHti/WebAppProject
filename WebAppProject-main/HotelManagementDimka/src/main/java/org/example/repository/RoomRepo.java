package org.example.repository;

import org.example.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
    List<Room> findAllByIdNotIn(List<Long> reservedRoomIds);

//    Iterable<Room> findByIsAvailable(boolean isAvailable);
}