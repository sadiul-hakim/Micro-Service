package com.user.userservice.service;

import com.user.userservice.client.ApiGateway;
import com.user.userservice.model.UserModel;
import com.user.userservice.pojo.Hotel;
import com.user.userservice.pojo.Rating;
import com.user.userservice.pojo.User;
import com.user.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final ApiGateway apiGateway;
    public User save(UserModel user){
        UserModel model = userRepository.save(user);
        return mapper.map(model, User.class);
    }
    public User getById(long userId){
        UserModel model = userRepository.findById(userId)
                .orElseGet(UserModel::new);

        // Convert the model into pojo
        User user = mapper.map(model, User.class);

        // Get all the ratings of the user and set in pojo
        List<Rating> allRatingsOfUser = apiGateway.getAllRatingsOfUser(model.getId());
        user.setRating(allRatingsOfUser);

        // Get rated hotel and set in rating pojo
        allRatingsOfUser.forEach(rating -> {
            Hotel hotel = apiGateway.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        });

        return user;
    }
    public List<User> getAll(){
        List<UserModel> models = userRepository.findAll();
        return models.stream().map(item->mapper.map(item,User.class)).toList();
    }
}
