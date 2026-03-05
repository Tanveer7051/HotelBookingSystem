package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reviewTable")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long userId;
    private Long hotelId;
    private Double rating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}