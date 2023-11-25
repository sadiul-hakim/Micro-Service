package com.rating.ratingservice.repository;

import com.rating.ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    List<Rating> findByHotelId(long hotelId);
    List<Rating> findByUserId(long userId);
}
