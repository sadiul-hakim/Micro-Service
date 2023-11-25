package com.hotel.hotelservice.controller;

import com.hotel.hotelservice.model.Hotel;
import com.hotel.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Hotel hotel){
        Hotel savedHotel = hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<?> findById(@PathVariable long hotelId){
        Hotel hotel = hotelService.getById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> findAll(){
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }
}
