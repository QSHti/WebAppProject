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

    public Guest findGuestByLastName(String lastName) {
        return guestRepository.findByLastName(lastName);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    // Дополнительные методы управления гостями
}

