package com.user.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private long userId;
    private long id;
    private long hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
