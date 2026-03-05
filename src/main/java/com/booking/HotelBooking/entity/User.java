package com.booking.HotelBooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name="userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String User_Id;
    private String userFirst_name;
    private String userLast_name;
    private String UserEmail;
    private String userAddress;
    private String userPassword;
}