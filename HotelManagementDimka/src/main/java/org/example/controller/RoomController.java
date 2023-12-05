package org.example.controller;

import org.example.entity.Room;
import org.example.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room newRoom = roomService.saveRoom(room);
        return ResponseEntity.ok(newRoom);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Room>> getAllRooms() {
        Iterable<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    /*@GetMapping("/available")
    public ResponseEntity<Iterable<Room>> getAvailableRooms(@RequestParam boolean isAvailable) {
        Iterable<Room> availableRooms = roomService.getAvailableRooms(isAvailable);
        return ResponseEntity.ok(availableRooms);
    }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }
}
