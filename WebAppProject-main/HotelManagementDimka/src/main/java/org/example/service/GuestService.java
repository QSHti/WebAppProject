package org.example.service;

import org.example.entity.Guest;
import org.example.repository.GuestRepo;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    private final GuestRepo guestRepository;

    public GuestService(GuestRepo guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest registerGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public Guest getGuestByEmail(String emailId) {
        return guestRepository.findByEmail(emailId).orElse(null);
    }

}

