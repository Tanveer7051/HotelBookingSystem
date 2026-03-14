package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByHotel_HotelId(Long hotelId);
    Optional<Room> findByRoomIdAndHotel_HotelId(Long roomId, Long hotelId);
 }

