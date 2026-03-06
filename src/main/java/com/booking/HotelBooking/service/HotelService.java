package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Hotel;
import com.booking.HotelBooking.repository.HotelRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel add(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
