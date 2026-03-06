package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Booking;
import com.booking.HotelBooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.add(booking);
    }
}