package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.User;
import com.booking.HotelBooking.repository.UserRepsitory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepsitory userRepsitory;

    public UserService(UserRepsitory userRepsitory) {
        this.userRepsitory = userRepsitory;
    }

    public User add(User user) {
        return userRepsitory.save(user);
    }
}
