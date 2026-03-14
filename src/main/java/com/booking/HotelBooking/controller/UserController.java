package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.User;
import com.booking.HotelBooking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @GetMapping("/{Id}")
    public User getUserById(@PathVariable Long Id){
       return userService.getUser(Id);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<User> getUserByIdAndUpdate(@PathVariable Long Id, @RequestBody User user){
         userService.getUserByIdAndUpdate(Id, user);
         return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{Id}")
    public String getUserByIdAndDelete(@PathVariable Long Id){
        return userService.delteUser(Id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUser(){
        userService.delelteAll();
        return  ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted All User");
    }
}
