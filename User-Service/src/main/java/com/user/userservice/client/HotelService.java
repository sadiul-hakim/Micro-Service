package com.user.userservice.client;

import com.user.userservice.pojo.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/get/{hotelId}")
    Hotel getHotel(@PathVariable long hotelId);
}
