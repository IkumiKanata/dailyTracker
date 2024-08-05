package com.example.dailytracker.model;

import com.example.dailytracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {

    private User user;
    private String token;
}
