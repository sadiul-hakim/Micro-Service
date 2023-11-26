package com.user.userservice.client;

import com.user.userservice.pojo.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("/rating/get-by-user/{userId}")
    List<Rating> getAllRatingsOfUser(@PathVariable long userId);
}
