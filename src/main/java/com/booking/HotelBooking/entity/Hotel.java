package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="hotelTable")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;
    private String hotelDescription;
    private String hotelAddress;
    private String hotelCity;
    private String hotelState;
    private String hotelCountry;
    private String hotelPostalCode;
    private String hotelPhoneNumber;
    private String hotelEmail;
    private Double hotelRating;
    private Integer totalRooms;
    private String checkInTime;
    private String checkOutTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}