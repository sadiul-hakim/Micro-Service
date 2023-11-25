package com.hotel.hotelservice.service;

import com.hotel.hotelservice.model.Hotel;
import com.hotel.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    public Hotel save(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    public Hotel getById(long id){
        return hotelRepository.findById(id)
                .orElseGet(Hotel::new);
    }
    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }
}
