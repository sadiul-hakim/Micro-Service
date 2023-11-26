package com.user.userservice.pojo.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.user.userservice.pojo.Rating;

import java.io.IOException;

public class RatingSerializer extends JsonSerializer<Rating> {
    private static final String RATING_ID = "ratingId";
    private static final String USER_ID = "userId";
    private static final String HOTEL_ID = "hotelId";
    private static final String RATING = "rating";
    private static final String FEEDBACK = "feedback";

    @Override
    public void serialize(Rating rating, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField(RATING_ID,rating.getId());
        jsonGenerator.writeNumberField(USER_ID,rating.getUserId());
        jsonGenerator.writeNumberField(HOTEL_ID,rating.getHotelId());
        jsonGenerator.writeNumberField(RATING,rating.getRating());
        jsonGenerator.writeStringField(FEEDBACK,rating.getFeedback());

        jsonGenerator.writeEndObject();
    }
}
