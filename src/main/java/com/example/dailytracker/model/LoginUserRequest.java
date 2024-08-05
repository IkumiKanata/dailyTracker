package com.example.dailytracker.model;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String username;
    private String password;
}
