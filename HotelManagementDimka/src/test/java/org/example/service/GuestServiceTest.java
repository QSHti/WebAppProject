/*package org.example.service;

import org.example.entity.Guest;
import org.example.repository.GuestRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GuestServiceTest {
    @Mock
    private GuestRepo guestRepository;
    @InjectMocks
    private GuestService guestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerGuest_ShouldReturnRegisteredGuest() {
        Guest guest = new Guest("John", "Doe", "john.doe@example.com");
        when(guestRepository.save(any(Guest.class))).thenReturn(guest);

        Guest registeredGuest = guestService.registerGuest(guest);

        assertNotNull(registeredGuest);
        assertEquals("John", registeredGuest.getFirstName());
        verify(guestRepository).save(guest);
    }

    @Test
    void findGuestByLastName_ShouldReturnGuest() {
        String lastName = "Doe";
        Guest guest = new Guest("John", lastName, "john.doe@example.com");
        when(guestRepository.findByLastName(lastName)).thenReturn(guest);

        Guest foundGuest = guestService.findGuestByLastName(lastName);

        assertNotNull(foundGuest);
        assertEquals(lastName, foundGuest.getLastName());
    }

    @Test
    void deleteGuest_ShouldCallDeleteMethod() {
        Long guestId = 1L;
        doNothing().when(guestRepository).deleteById(guestId);

        guestService.deleteGuest(guestId);

        verify(guestRepository).deleteById(guestId);
    }
}
*/