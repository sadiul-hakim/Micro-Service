package com.user.userservice.model;

import com.user.userservice.pojo.Rating;
import com.user.userservice.pojo.converter.RatingConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String about;
    @Convert(converter = RatingConverter.class)
    @Column(columnDefinition = "JSON")
    private List<Rating> rating = new ArrayList<>();
}
