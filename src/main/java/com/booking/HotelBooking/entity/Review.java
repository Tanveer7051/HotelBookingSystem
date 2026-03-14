package com.booking.HotelBooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="reviewTable")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @NotNull(message = "Rating is required")
    private Double rating;

    @NotNull(message = "Comment cannot be empty")
    @Size(min = 3, message = "Comment must be at least 3 characters")
    private String comment;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="hotelId")
    private Hotel hotel;

    public Review() {
    }

    public Review(Long reviewId, Double rating, String comment, LocalDateTime createdAt, LocalDateTime updatedAt, User user, Hotel hotel) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.hotel = hotel;
    }
}
