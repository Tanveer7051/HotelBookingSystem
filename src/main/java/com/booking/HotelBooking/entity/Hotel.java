package com.booking.HotelBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hotelTable")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @NotBlank(message = "Hotel name is required")
    private String hotelName;

    @NotBlank(message = "Description is required")
    private String hotelDescription;

    @NotBlank(message = "Address is required")
    private String hotelAddress;

    @NotBlank(message = "City is required")
    private String hotelCity;

    @NotBlank(message = "State is required")
    private String hotelState;

    @NotBlank(message = "Country is required")
    private String hotelCountry;

    @NotBlank(message = "Postal code is required")
    private String hotelPostalCode;

    @NotBlank(message = "Phone number is required")
    private String hotelPhoneNumber;

    @NotBlank(message = "Email is required")
    private String hotelEmail;

    @NotNull(message = "Rating cannot be null")
    private Double hotelRating;

    @Positive(message = "Total rooms must be greater than 0")
    private Integer totalRooms;

    @NotBlank(message = "Check-in time required")
    private String checkInTime;

    @NotBlank(message = "Check-out time required")
    private String checkOutTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Review> review= new ArrayList<>();

    public Hotel(String hotelCity, Long hotelId, String hotelName, String hotelDescription, String hotelAddress, String hotelState, String hotelCountry, String hotelPostalCode, String hotelPhoneNumber, String hotelEmail, Double hotelRating, Integer totalRooms, String checkInTime, String checkOutTime, LocalDateTime createdAt, LocalDateTime updatedAt, List<Room> rooms, List<Review> review) {
        this.hotelCity = hotelCity;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.hotelAddress = hotelAddress;
        this.hotelState = hotelState;
        this.hotelCountry = hotelCountry;
        this.hotelPostalCode = hotelPostalCode;
        this.hotelPhoneNumber = hotelPhoneNumber;
        this.hotelEmail = hotelEmail;
        this.hotelRating = hotelRating;
        this.totalRooms = totalRooms;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.rooms = rooms;
        this.review = review;
    }

    public Hotel() {
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelState() {
        return hotelState;
    }

    public void setHotelState(String hotelState) {
        this.hotelState = hotelState;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelPostalCode() {
        return hotelPostalCode;
    }

    public void setHotelPostalCode(String hotelPostalCode) {
        this.hotelPostalCode = hotelPostalCode;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public Double getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Double hotelRating) {
        this.hotelRating = hotelRating;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
