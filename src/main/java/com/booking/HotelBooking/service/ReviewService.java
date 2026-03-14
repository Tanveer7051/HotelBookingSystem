package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Hotel;
import com.booking.HotelBooking.entity.Review;
import com.booking.HotelBooking.entity.User;
import com.booking.HotelBooking.exceptionHandler.DataBaseIsEmpty;
import com.booking.HotelBooking.exceptionHandler.HotelNotFound;
import com.booking.HotelBooking.exceptionHandler.ReviewNotFound;
import com.booking.HotelBooking.exceptionHandler.UserNotFoundException;
import com.booking.HotelBooking.repository.HotelRepository;
import com.booking.HotelBooking.repository.ReviewRepository;
import com.booking.HotelBooking.repository.UserRepsitory;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HotelRepository hotelRepository;
    private final UserRepsitory userRepsitory;

    private final String  hotelNotFound="Hotel Not Found With This Id ";
    private final String userNotFound="User Not Found With This Id ";
    private final String reviewDataBaseEmpty="No One Has Review. Do The First Review And Get A Discount On Next Visit! ";

    private final String reviewNotFound = "No Review Found With This User id ";
    public ReviewService(ReviewRepository reviewRepository, HotelRepository hotelRepository, UserRepsitory userRepsitory) {
        this.reviewRepository = reviewRepository;
        this.hotelRepository = hotelRepository;
        this.userRepsitory = userRepsitory;
    }

    public Review createReview(Review review, Long userId,Long hotelId) {
     Hotel hotel=   hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound + hotelId));
        User user= userRepsitory.findById(userId)
                        .orElseThrow(()-> new UserNotFoundException(userNotFound+ userId));
        review.setUser(user);
        review.setHotel(hotel);
        return reviewRepository.save(review);
    }

    public List<Review> getAllReview() {
        Long count=reviewRepository.count();
        List<Review> reviews= reviewRepository.findAll();
//        if(count==0){
//            throw new DataBaseIsEmpty(reviewDataBaseEmpty);
//        }
        if(reviews.isEmpty()){
            throw new DataBaseIsEmpty(reviewDataBaseEmpty);
        }
        return reviews;
    }

    public List<Review> getReview(Long userId) {
        userRepsitory.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User Not Found With This Id "+ userId));
        List<Review> reviews= reviewRepository.findByUser_userId(userId);
        if(reviews.isEmpty()){
            throw new ReviewNotFound(reviewNotFound+ userId);
        }
        return reviewRepository.findByUser_userId(userId);
    }

    public List<Review> getAllHotelReview(long hotelId) {
        List<Review> reviews = reviewRepository.findByHotel_hotelId(hotelId);
        hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound + hotelId));
        if(reviews.isEmpty()){
            throw new ReviewNotFound("Become The First Person to review And get a chance to discount on next visit");
        }
        return reviews;
    }
    public void deleteReviews(){
        List<Review> reviews= reviewRepository.findAll();
        if(reviews.isEmpty()){
            throw  new ReviewNotFound("Already Deleted. ThankYou! ");
        }
        reviewRepository.deleteAll();
    }
}
