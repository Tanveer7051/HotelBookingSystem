package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Check-in date required")
    private LocalDate checkInDate;

    @NotNull(message = "Check-out date required")
    private LocalDate checkOutDate;

    @NotNull(message = "Total price required")
    @Positive(message = "Price must be positive")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Booking status required")
    private BookingStatus bookingStatus= BookingStatus.PENDING;

    @NotNull(message = "Number of guests required")
    @Positive(message = "Guests must be at least 1")
    private Integer numberOfGuests;

    private String specialRequests;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Booking() {
    }

    public Booking(Long id, LocalDate checkInDate, LocalDate checkOutDate, BigDecimal totalPrice, BookingStatus bookingStatus, Integer numberOfGuests, String specialRequests, LocalDateTime createdAt, LocalDateTime updatedAt, User user, Room room) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
        this.numberOfGuests = numberOfGuests;
        this.specialRequests = specialRequests;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.room = room;
    }

}