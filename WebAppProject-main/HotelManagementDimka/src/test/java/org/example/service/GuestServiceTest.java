package org.example.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.entity.Guest;
import org.example.repository.GuestRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GuestService.class})
@ExtendWith(SpringExtension.class)
class GuestServiceTest {
    @MockBean
    private GuestRepo guestRepo;

    @Autowired
    private GuestService guestService;

    /**
     * Method under test: {@link GuestService#registerGuest(Guest)}
     */
    @Test
    void testRegisterGuest() {
        Guest guest = new Guest("Jane", "Doe", "jane.doe@example.org");

        when(guestRepo.save(Mockito.<Guest>any())).thenReturn(guest);
        Guest actualRegisterGuestResult = guestService.registerGuest(new Guest("Jane", "Doe", "jane.doe@example.org"));
        verify(guestRepo).save(Mockito.<Guest>any());
        assertSame(guest, actualRegisterGuestResult);
    }

    /**
     * Method under test: {@link GuestService#getGuestById(Long)}
     */
    @Test
    void testGetGuestById() {
        Guest guest = new Guest("Jane", "Doe", "jane.doe@example.org");

        Optional<Guest> ofResult = Optional.of(guest);
        when(guestRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Guest actualGuestById = guestService.getGuestById(1L);
        verify(guestRepo).findById(Mockito.<Long>any());
        assertSame(guest, actualGuestById);
    }

    /**
     * Method under test: {@link GuestService#deleteGuest(Long)}
     */
    @Test
    void testDeleteGuest() {
        doNothing().when(guestRepo).deleteById(Mockito.<Long>any());
        guestService.deleteGuest(1L);
        verify(guestRepo).deleteById(Mockito.<Long>any());
    }
}
