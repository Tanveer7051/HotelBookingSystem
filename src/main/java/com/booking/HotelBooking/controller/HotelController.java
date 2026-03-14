package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Hotel;
import com.booking.HotelBooking.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public Hotel createHotel(@Valid @RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id){
        return hotelService.deleteHotel(id);
    }
    @GetMapping("/search")
    public List<Hotel> searchHotels(@RequestParam(required = false) String search) {
        return hotelService.searchHotels(search);
    }

}