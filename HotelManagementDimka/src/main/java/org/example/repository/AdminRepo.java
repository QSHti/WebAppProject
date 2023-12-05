package org.example.repository;

import org.example.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {

    Admin findByUsername(String username);

}

