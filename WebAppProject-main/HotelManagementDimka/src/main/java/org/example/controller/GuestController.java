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

  @PostMapping("/create")
  public ResponseEntity<Guest> registerGuest(@RequestBody Guest guest) {
    Guest registeredGuest = guestService.registerGuest(guest);
    return ResponseEntity.ok(registeredGuest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Guest> getGuesById(@PathVariable Long id) {
    Guest guest = guestService.getGuestById(id);
    if (guest == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(guest);
  }

  @GetMapping("/email/{emailId}")
  public ResponseEntity<Guest> getGuestByEmail(@PathVariable String emailId) {
    Guest guest = guestService.getGuestByEmail(emailId);
    if (guest == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(guest);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
    guestService.deleteGuest(id);
    return ResponseEntity.ok().build();
  }

}

