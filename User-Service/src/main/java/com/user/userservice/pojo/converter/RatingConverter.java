package com.user.userservice.pojo.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.userservice.pojo.Rating;
import jakarta.persistence.AttributeConverter;

import java.util.List;

public class RatingConverter implements AttributeConverter<List<Rating>,String> {
    private static final ObjectMapper mapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(List<Rating> attribute) {
        try{
            mapper.writeValueAsString(attribute);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rating> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData,mapper.getTypeFactory().constructCollectionType(List.class, Rating.class));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
