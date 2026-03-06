package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Room;
import com.booking.HotelBooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room add(Room room) {
        return roomRepository.save(room);
    }
}