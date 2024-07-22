package com.example.dailytracker.model;

import lombok.Data;

@Data
public class CreateHabitRequest {
    private Integer userId;
    private String habitName;
}
