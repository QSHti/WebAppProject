package org.example.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("GUESTS")
@Getter
public class Guest {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Guest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }
}

