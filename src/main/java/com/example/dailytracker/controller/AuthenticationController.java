package com.example.dailytracker.controller;

import com.example.dailytracker.entity.User;
import com.example.dailytracker.model.RegisterUserRequest;
import com.example.dailytracker.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterUserRequest request) {
        return authenticationService.registerUser(request.getUsername(), request.getEmail(), request.getPassword());

    }
}