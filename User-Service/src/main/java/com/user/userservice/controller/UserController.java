package com.user.userservice.controller;

import com.user.userservice.model.User;
import com.user.userservice.service.UserService;
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
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getById(@PathVariable long userId){
        User user = userService.getById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        List<User> allUser = userService.getAll();
        return ResponseEntity.ok(allUser);
    }
}
