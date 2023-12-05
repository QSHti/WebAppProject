package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("ROOMS")
@Getter
@Setter
public class Room {

    @Id
    private Long id;
    private String roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double pricePerNight;

    /*public void makeAvailable() { this.isAvailable = true; }
    public void makeUnavailable() { this.isAvailable = false; }
*/
}
