package com.user.userservice.pojo.converter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.user.userservice.pojo.Hotel;
import com.user.userservice.pojo.Rating;

import java.io.IOException;

public class RatingDeserializer extends JsonDeserializer<Rating> {
    private static final String RATING_ID = "ratingId";
    private static final String USER_ID = "userId";
    private static final String HOTEL_ID = "hotelId";
    private static final String RATING = "rating";
    private static final String FEEDBACK = "feedback";
    @Override
    public Rating deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode jsonNode = jsonParser.readValueAsTree();
        long ratingId = jsonNode.get(RATING_ID).asLong();
        long userId = jsonNode.get(USER_ID).asLong();
        long hotelId = jsonNode.get(HOTEL_ID).asLong();
        int rating = jsonNode.get(RATING).asInt();
        String feedback = jsonNode.get(FEEDBACK).asText();

        return new Rating(userId,ratingId,hotelId,rating,feedback,new Hotel());
    }
}
