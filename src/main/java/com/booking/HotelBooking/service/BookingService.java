package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Booking;
import com.booking.HotelBooking.entity.Room;
import com.booking.HotelBooking.entity.User;
import com.booking.HotelBooking.exceptionHandler.DataBaseIsEmpty;
import com.booking.HotelBooking.exceptionHandler.RoomNotFoundException;
import com.booking.HotelBooking.exceptionHandler.UserNotFoundException;
import com.booking.HotelBooking.repository.BookingRepository;
import com.booking.HotelBooking.repository.RoomRepository;
import com.booking.HotelBooking.repository.UserRepsitory;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookingService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final UserRepsitory userRepsitory;

    private final String emptyDatabase="Database is Empty. No Records Found In DataBase!";
    private final String userNotFound="User Not Found With This Id, Please Check the Id And Proceed Again Later ";

    public BookingService(BookingRepository bookingRepository, UserRepsitory userRepsitory, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepsitory = userRepsitory;
        this.roomRepository=roomRepository;
    }

    public Booking addBooking(Booking booking, Long userId, Long roomId) {
        User user=userRepsitory.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User Not Found With This "+ userId));
        Room room=roomRepository.findById(roomId)
                .orElseThrow(()-> new RoomNotFoundException("Room Not Found With This "+ roomId));

                booking.setRoom(room);
                booking.setUser(user);
               return bookingRepository.save(booking);
    }

    public List<Booking> getBooking() {
//        long count=bookingRepository.count();
//        if(count ==0){
//            throw new DataBaseIsEmpty(emptyDatabase);
//        }
//        return bookingRepository.findAll();
        var out = bookingRepository.findAll();
        if (out.isEmpty()){
            throw new DataBaseIsEmpty(emptyDatabase);
        }
        return out;
    }

    public List<Booking> userBooking(Long userId) {
       userRepsitory.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userNotFound + userId));
        return bookingRepository.findByUser_userId(userId);
    }

    public void deleteBooking(Long userId, Long bookingId) {

        Booking booking = bookingRepository
                .findByIdAndUser_userId(bookingId, userId)
                .orElseThrow(() -> new DataBaseIsEmpty("User does not have any booking yet!"));

        bookingRepository.delete(booking);
    }

    public Booking updateBooking(Booking bookingUpdate, Long bookingId) {
        Booking booking=bookingRepository.findById(bookingId)
                .orElseThrow(()-> new RoomNotFoundException("Booking Not Found With This id "+ bookingId));
         booking.setBookingStatus(bookingUpdate.getBookingStatus());
         return bookingRepository.save(booking);
    }
}