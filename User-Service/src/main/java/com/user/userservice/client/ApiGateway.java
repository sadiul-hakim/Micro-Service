package com.user.userservice.client;

import com.user.userservice.pojo.Hotel;
import com.user.userservice.pojo.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "API-GATEWAY")
public interface ApiGateway {
    @GetMapping("/hotel/get/{hotelId}")
    Hotel getHotel(@PathVariable long hotelId);
    @GetMapping("/rating/get-by-user/{userId}")
    List<Rating> getAllRatingsOfUser(@PathVariable long userId);
}
