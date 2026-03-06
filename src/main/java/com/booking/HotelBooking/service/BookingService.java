package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Booking;
import com.booking.HotelBooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking add(Booking booking) {
        return bookingRepository.save(booking);
    }
}