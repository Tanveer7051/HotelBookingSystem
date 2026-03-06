package com.booking.HotelBooking.repository;

import com.booking.HotelBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepsitory extends JpaRepository<User,Long> {
}
