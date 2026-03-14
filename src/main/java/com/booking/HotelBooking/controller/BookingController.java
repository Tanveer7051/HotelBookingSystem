package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Booking;
import com.booking.HotelBooking.service.BookingService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@Data
public class BookingController {

    private BookingService bookingService;

    public BookingController( BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/user/{userId}/rooms/{roomId}")
    public Booking addBooking(@RequestBody Booking booking,@PathVariable Long userId, @PathVariable Long roomId){
        return bookingService.addBooking(booking,userId, roomId);
    }

    @GetMapping()
    public List<Booking> getAllBooking(){
        return bookingService.getBooking();
    }

    @GetMapping("/user/{userId}")
    public List<Booking> userBooking(@PathVariable Long userId){
        return bookingService.userBooking(userId);
    }
    @DeleteMapping("/{bookingId}/user/{userId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId,@PathVariable Long userId){
        bookingService.deleteBooking(userId,bookingId);
         return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete");
    }

    @PutMapping("/{bookingId}")
    public Booking updateBookingStatus(@RequestBody Booking booking, @PathVariable Long bookingId){
        return bookingService.updateBooking(booking, bookingId);
    }
}