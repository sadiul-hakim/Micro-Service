package com.user.userservice.service;

import com.user.userservice.model.User;
import com.user.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User save(User user){
        return userRepository.save(user);
    }
    public User getById(long userId){
        return userRepository.findById(userId)
                .orElseGet(User::new);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
