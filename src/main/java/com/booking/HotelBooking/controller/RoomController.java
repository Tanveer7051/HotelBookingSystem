package com.booking.HotelBooking.controller;

import com.booking.HotelBooking.entity.Room;
import com.booking.HotelBooking.service.RoomService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@Data
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/hotels/{hotelId}/rooms")

    public ResponseEntity<Room> addRoomToHotel(@PathVariable Long hotelId,@RequestBody Room rooms){
        Room room=roomService.addRoom(hotelId,rooms);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    @GetMapping("/hotels/{hotelId}/rooms")

    public List<Room> getRooms(@PathVariable Long hotelId){
        return roomService.getRooms(hotelId);
    }

    @GetMapping("hotels/{hotelId}/rooms/{roomId}")

    public Room getRoomById(@PathVariable Long hotelId, @PathVariable Long roomId){
        return roomService.findRoom(hotelId, roomId);
    }

    @DeleteMapping("hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<String> deleteRoomById(@PathVariable Long hotelId, @PathVariable Long roomId){
        roomService.deleteRoom(hotelId, roomId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Deleted! ");
    }

    @PutMapping("hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long hotelId, @PathVariable Long roomId,@RequestBody Room rooms){
        Room room=roomService.updateRoom(rooms,hotelId, roomId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(room);
    }
}