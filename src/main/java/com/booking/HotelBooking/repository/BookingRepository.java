package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByUser_userId(Long id);
    Optional<Booking> findByIdAndUser_userId(Long bookingId, Long userId);
}
