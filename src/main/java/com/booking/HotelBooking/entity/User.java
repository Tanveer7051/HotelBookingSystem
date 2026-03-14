package com.booking.HotelBooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

    @Column(unique = true)
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
    @JsonIgnore
    private List<Booking> booking = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Review> review = new ArrayList<>();

    public User() {
    }

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
}
