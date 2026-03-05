package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="roomTable")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private Long hotelId;
    private String roomNumber;
    private String roomType;
    private Double pricePerNight;
    private Integer capacity;
    private String bedType;
    private String description;
    private String availabilityStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}