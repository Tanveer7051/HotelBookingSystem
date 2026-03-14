package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Review;
import com.booking.HotelBooking.service.ReviewService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Data
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/user/{userId}/hotel/{hotelId}")
    public Review createReview(@RequestBody Review review, @PathVariable Long userId,@PathVariable Long hotelId){
        return reviewService.createReview(review,userId, hotelId);
    }

    @GetMapping
    public List<Review> getAllReview(){
        return reviewService.getAllReview();
    }

    @GetMapping("/user/{userId}")
    public List<Review> getReview(@PathVariable Long userId){
        return reviewService.getReview(userId);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Review> getHotelReview(@PathVariable long hotelId){
        return reviewService.getAllHotelReview(hotelId);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteReviews(){
        reviewService.deleteReviews();
        return ResponseEntity.ok("Successfully Deleted !");
    }
}
