package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
