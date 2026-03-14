package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="hotelTable")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @NotBlank(message = "Hotel name is required")
    private String hotelName;

    @NotBlank(message = "Description is required")
    private String hotelDescription;

    @NotBlank(message = "Address is required")
    private String hotelAddress;

    @NotBlank(message = "City is required")
    private String hotelCity;

    @NotBlank(message = "State is required")
    private String hotelState;

    @NotBlank(message = "Country is required")
    private String hotelCountry;

    @NotBlank(message = "Postal code is required")
    private String hotelPostalCode;

    @NotBlank(message = "Phone number is required")
    private String hotelPhoneNumber;

    @NotBlank(message = "Email is required")
    private String hotelEmail;

    @NotNull(message = "Rating cannot be null")
    private Double hotelRating;

    @Positive(message = "Total rooms must be greater than 0")
    private Integer totalRooms;

    @NotBlank(message = "Check-in time required")
    private String checkInTime;

    @NotBlank(message = "Check-out time required")
    private String checkOutTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Review> review= new ArrayList<>();

    public Hotel() {
    }

    public Hotel(Long hotelId, String hotelName, String hotelDescription, String hotelAddress, String hotelCity, String hotelState, String hotelCountry, String hotelPostalCode, String hotelPhoneNumber, String hotelEmail, Double hotelRating, Integer totalRooms, String checkInTime, String checkOutTime, LocalDateTime createdAt, LocalDateTime updatedAt, List<Room> rooms, List<Review> review) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.hotelAddress = hotelAddress;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelCountry = hotelCountry;
        this.hotelPostalCode = hotelPostalCode;
        this.hotelPhoneNumber = hotelPhoneNumber;
        this.hotelEmail = hotelEmail;
        this.hotelRating = hotelRating;
        this.totalRooms = totalRooms;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.rooms = rooms;
        this.review = review;
    }
}
