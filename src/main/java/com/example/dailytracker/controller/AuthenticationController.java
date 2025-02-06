package com.example.dailytracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

//    private final AuthenticationService authenticationService;

//    public AuthenticationController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @PostMapping("/register")
//    public User register(@RequestBody RegisterUserRequest request) {
//        return authenticationService.registerUser(request.getUsername(), request.getEmail(), request.getPassword());
//    }
//
//    @PostMapping("/login")
//    public LoginUserResponse login(@RequestBody LoginUserRequest request) {
//        return authenticationService.loginUser(request.getUsername(), request.getPassword());
//    }
}