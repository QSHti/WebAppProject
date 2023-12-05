package org.example.repository;

import org.example.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
    /* Iterable<Room> findByIsAvailable(boolean isAvailable);
     */
}