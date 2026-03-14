package com.booking.HotelBooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="roomTable")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotBlank(message = "Room type is required")
    private String roomType;

    @NotNull(message = "Price per night required")
    @Positive(message = "Price must be positive")
    private Double pricePerNight;

    @NotNull(message = "Capacity is required")
    @Positive(message = "Capacity must be positive")
    private Integer capacity;

    @NotBlank(message = "Bed type required")
    private String bedType;

    private String description;

    private String availabilityStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name="hotelId")
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Booking> booking = new ArrayList<>();

    public Room() {
    }

    public Room(Long roomId, String roomNumber, String roomType, Double pricePerNight, Integer capacity, String bedType, String description, String availabilityStatus, LocalDateTime createdAt, LocalDateTime updatedAt, Hotel hotel, List<Booking> booking) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.bedType = bedType;
        this.description = description;
        this.availabilityStatus = availabilityStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.hotel = hotel;
        this.booking = booking;
    }
}

