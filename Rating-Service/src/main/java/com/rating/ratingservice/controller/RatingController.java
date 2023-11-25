package com.rating.ratingservice.controller;

import com.rating.ratingservice.model.Rating;
import com.rating.ratingservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Rating rating) {
        Rating savedRating = ratingService.save(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping("/get/{ratingId}")
    public ResponseEntity<?> getById(@PathVariable long ratingId) {
        Rating rating = ratingService.getById(ratingId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("/get-by-hotel/{id}")
    public ResponseEntity<?> getByHotelId(@PathVariable long id) {
        List<Rating> ratings = ratingService.getByHotelId(id);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/get-by-user/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable long id) {
        List<Rating> ratings = ratingService.getByUserId(id);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        List<Rating> ratings = ratingService.getAll();
        return ResponseEntity.ok(ratings);
    }
}
