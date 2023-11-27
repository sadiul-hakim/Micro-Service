package com.user.userservice.controller;

import com.user.userservice.model.UserModel;
import com.user.userservice.pojo.User;
import com.user.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserModel user){
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/get/{userId}")
    @CircuitBreaker(name = "RATING_HOTEL_BREAKER",fallbackMethod = "RATING_HOTEL_FALLBACK")
    public ResponseEntity<?> getById(@PathVariable long userId){
        User user = userService.getById(userId);
        return ResponseEntity.ok(user);
    }

    // FallBack method
    public ResponseEntity<?> RATING_HOTEL_FALLBACK(long userId,Exception ex){
        User user = new User();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        List<User> allUser = userService.getAll();
        return ResponseEntity.ok(allUser);
    }
}
