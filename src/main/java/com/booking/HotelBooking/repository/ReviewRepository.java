package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
