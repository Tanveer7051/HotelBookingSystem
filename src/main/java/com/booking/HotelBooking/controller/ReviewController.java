package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Review;
import com.booking.HotelBooking.service.ReviewService;
import com.booking.HotelBooking.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{userId}/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }
}
