package org.example.service;

import org.example.entity.Room;
import org.example.repository.RoomRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest {

    @Mock
    private RoomRepo roomRepository;

    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveRoom_ShouldReturnSavedRoom() {
        // Arrange
        Room room = new Room();
        when(roomRepository.save(any(Room.class))).thenReturn(room);

        // Act
        Room savedRoom = roomService.saveRoom(room);

        // Assert
        assertNotNull(savedRoom);
        verify(roomRepository).save(room);
    }
}
