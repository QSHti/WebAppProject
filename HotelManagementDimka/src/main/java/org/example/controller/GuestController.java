package org.example.controller;

import org.example.entity.Guest;
import org.example.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/")
    public ResponseEntity<Guest> registerGuest(@RequestBody Guest guest) {
        Guest registeredGuest = guestService.registerGuest(guest);
        return ResponseEntity.ok(registeredGuest);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<Guest> getGuestByLastName(@PathVariable String lastName) {
        Guest guest = guestService.findGuestByLastName(lastName);
        return ResponseEntity.ok(guest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.ok().build();
    }

}

