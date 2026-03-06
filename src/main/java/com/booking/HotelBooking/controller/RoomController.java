package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Room;
import com.booking.HotelBooking.service.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room){
        return roomService.add(room);
    }
}