package org.example.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private String roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double pricePerNight;
}