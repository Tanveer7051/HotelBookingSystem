package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
