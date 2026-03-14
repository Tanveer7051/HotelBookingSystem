package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.Hotel;
import com.booking.HotelBooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByHotelNameContainingIgnoreCaseOrHotelCityContainingIgnoreCaseOrHotelCountryContainingIgnoreCase(
            String name, String city, String country
    );}
