package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser_userId(long userId);
    List<Review> findByHotel_hotelId(long hotelId);
}