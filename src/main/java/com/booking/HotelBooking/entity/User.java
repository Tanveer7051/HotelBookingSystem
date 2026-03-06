package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "First name is required")
    private String userFirst_name;

    @NotBlank(message = "Last name is required")
    private String userLast_name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String userEmail;

    @NotBlank(message = "Address is required")
    private String userAddress;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private Role role=Role.USER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> booking = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> review = new ArrayList<>();

    public User(Long userId, String userFirst_name, String userLast_name, String userEmail, String userAddress, String userPassword, Role role, List<Booking> booking, List<Review> review) {
        this.userId = userId;
        this.userFirst_name = userFirst_name;
        this.userLast_name = userLast_name;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
        this.role = role;
        this.booking = booking;
        this.review = review;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirst_name() {
        return userFirst_name;
    }

    public void setUserFirst_name(String userFirst_name) {
        this.userFirst_name = userFirst_name;
    }

    public String getUserLast_name() {
        return userLast_name;
    }

    public void setUserLast_name(String userLast_name) {
        this.userLast_name = userLast_name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }


}
