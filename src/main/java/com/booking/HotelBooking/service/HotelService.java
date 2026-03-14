package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Hotel;
import com.booking.HotelBooking.exceptionHandler.DataBaseIsEmpty;
import com.booking.HotelBooking.exceptionHandler.HotelNotFound;
import com.booking.HotelBooking.repository.HotelRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class HotelService {

    String dbEmpty="No Hotel is Found in Database.Database is Empty! ";
    String hotelNotFound="hotel not found with id ";
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        Long count=hotelRepository.count();
        if(count==0){
            throw new DataBaseIsEmpty(dbEmpty);
        }
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound + id));
    }

    public String deleteHotel(Long id) {
        Hotel hotel= hotelRepository.findById(id)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound + id));
        hotelRepository.delete(hotel);
        return "Hotel Successfully Deleted! ";
    }

    public Hotel updateHotel(Long id, Hotel updateHotel) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound + id));

        hotel.setHotelName(updateHotel.getHotelName());
        hotel.setHotelDescription(updateHotel.getHotelDescription());
        hotel.setHotelAddress(updateHotel.getHotelAddress());
        hotel.setHotelCity(updateHotel.getHotelCity());
        hotel.setHotelState(updateHotel.getHotelState());
        hotel.setHotelCountry(updateHotel.getHotelCountry());
        hotel.setHotelPostalCode(updateHotel.getHotelPostalCode());
        hotel.setHotelPhoneNumber(updateHotel.getHotelPhoneNumber());
        hotel.setHotelEmail(updateHotel.getHotelEmail());
        hotel.setHotelRating(updateHotel.getHotelRating());
        hotel.setTotalRooms(updateHotel.getTotalRooms());
        hotel.setCheckInTime(updateHotel.getCheckInTime());
        hotel.setCheckOutTime(updateHotel.getCheckOutTime());

        return hotelRepository.save(hotel);
    }

    public List<Hotel> searchHotels(String search) {
        long count=hotelRepository.count();
        if(count==0){
            throw new DataBaseIsEmpty(dbEmpty);
        }
        List<Hotel> hotels;


        if (search != null && !search.isEmpty()) {
            hotels = hotelRepository.findByHotelNameContainingIgnoreCaseOrHotelCityContainingIgnoreCaseOrHotelCountryContainingIgnoreCase(
                    search, search, search
            );
            if(hotels.isEmpty()){
                throw new HotelNotFound("Hotel Not Found In This Area "+ search);
            }
        } else {
            hotels = hotelRepository.findAll();
        }

        return hotels;
    }
}
