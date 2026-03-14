package com.booking.HotelBooking.service;

import com.booking.HotelBooking.entity.Hotel;
import com.booking.HotelBooking.entity.Room;
import com.booking.HotelBooking.exceptionHandler.HotelNotFound;
import com.booking.HotelBooking.exceptionHandler.RoomNotFoundException;
import com.booking.HotelBooking.repository.HotelRepository;
import com.booking.HotelBooking.repository.RoomRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class RoomService {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    String hotelNotFound="Hotel Not Found With This ";
    String roomNotFound= "Room not found With This ";
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository=hotelRepository;
    }
    public Room addRoom(Long hotelId, Room rooms) {
        Hotel hotel=hotelRepository.findById(hotelId)
                .orElseThrow(()->new HotelNotFound(hotelNotFound+ hotelId));
        rooms.setHotel(hotel);
        return roomRepository.save(rooms);
    }

    public List<Room> getRooms(Long hotelId) {
        Hotel hotel= hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound));
       return roomRepository.findByHotel_HotelId(hotelId);
    }

    public Room findRoom(Long hotelId, Long roomId) {
        Hotel hotel= hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound));
        return roomRepository.findByRoomIdAndHotel_HotelId(roomId, hotelId)
                .orElseThrow(()-> new RoomNotFoundException(roomNotFound+ roomId));
    }

    public void deleteRoom(Long hotelId, Long roomId) {
        Hotel hotel= hotelRepository.findById(hotelId)
                .orElseThrow(()-> new HotelNotFound(hotelNotFound));
        Room room=roomRepository.findByRoomIdAndHotel_HotelId(roomId, hotelId)
                .orElseThrow(()-> new RoomNotFoundException(roomNotFound+ roomId));
        roomRepository.delete(room);
    }

    public Room updateRoom(Room updatedRoom, Long hotelId, Long roomId) {

        hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFound("Hotel not found"));

        Room room = roomRepository
                .findByRoomIdAndHotel_HotelId(roomId, hotelId)
                .orElseThrow(() -> new RoomNotFoundException(roomNotFound + roomId));

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setRoomType(updatedRoom.getRoomType());
        room.setPricePerNight(updatedRoom.getPricePerNight());
        room.setCapacity(updatedRoom.getCapacity());
        room.setBedType(updatedRoom.getBedType());
        room.setDescription(updatedRoom.getDescription());
        room.setAvailabilityStatus(updatedRoom.getAvailabilityStatus());
        room.setUpdatedAt(LocalDateTime.now());

        return roomRepository.save(room);
    }
}