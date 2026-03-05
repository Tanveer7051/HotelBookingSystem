package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name="bookingTable")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private Long userId; // FK to User
    private Long roomId; // FK to Room
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalPrice;
    private String bookingStatus;
    private String paymentStatus;
    private Integer numberOfGuests;
    private String specialRequests;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}