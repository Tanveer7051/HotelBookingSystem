package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.User;
import com.booking.HotelBooking.exceptionHandler.DataBaseIsEmpty;
import com.booking.HotelBooking.exceptionHandler.UserNotFoundException;
import com.booking.HotelBooking.repository.UserRepsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    String dbEmpty="No User is Found in Database.Database is Empty! ";
    String userNotFound="User not found with id ";
    private final UserRepsitory userRepsitory;

    public UserService(UserRepsitory userRepsitory) {
        this.userRepsitory = userRepsitory;
    }

    public User addUser(User user) {
        return userRepsitory.save(user);
    }

    public List<User> getAll() {
        Long user= userRepsitory.count();
        if(user==0){
            throw new DataBaseIsEmpty(dbEmpty);
        }
        return userRepsitory.findAll();
    }

    public User getUser(Long id) {
        return userRepsitory.findById(id)
                .orElseThrow(()-> new UserNotFoundException(userNotFound + id));

    }

    public User getUserByIdAndUpdate(Long id, User userDetails) {
        System.out.println("-----------------------------"+ id);
        User user = userRepsitory.findById(id)
                .orElseThrow(() -> new UserNotFoundException(userNotFound + id));
        user.setUserFirst_name(userDetails.getUserFirst_name());
        user.setUserLast_name(userDetails.getUserLast_name());
        user.setUserEmail(userDetails.getUserEmail());
        user.setUserAddress(userDetails.getUserAddress());
        user.setUserPassword(userDetails.getUserPassword());
        user.setRole(userDetails.getRole());

        return userRepsitory.save(user);
    }

    public String delteUser(Long id) {
        User user=userRepsitory.findById(id)
                        .orElseThrow(()-> new UserNotFoundException(userNotFound +id));
        userRepsitory.delete(user);
        return "Successfully Deleted!";
    }

    public void delelteAll() {
        Long count=userRepsitory.count();
        if(count==0){
            throw new DataBaseIsEmpty(dbEmpty);
        }
        userRepsitory.deleteAll();
    }
}
