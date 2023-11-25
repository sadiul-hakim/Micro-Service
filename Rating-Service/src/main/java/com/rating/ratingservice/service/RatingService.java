package com.rating.ratingservice.service;

import com.rating.ratingservice.model.Rating;
import com.rating.ratingservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    public Rating save(Rating rating){
        return ratingRepository.save(rating);
    }
    public Rating getById(long id){
        return ratingRepository.findById(id)
                .orElseGet(Rating::new);
    }
    public List<Rating> getByUserId(long id){
        return ratingRepository.findByUserId(id);
    }
    public List<Rating> getByHotelId(long id){
        return ratingRepository.findByHotelId(id);
    }
    public List<Rating> getAll(){
        return ratingRepository.findAll();
    }
}
