package org.example.repository;

import org.example.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends CrudRepository<Guest, Long> {
    Guest findByLastName(String lastName);

}
