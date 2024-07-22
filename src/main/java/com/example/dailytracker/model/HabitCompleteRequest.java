package com.example.dailytracker.model;

import lombok.Data;

@Data
public class HabitCompleteRequest {
    private Integer userId;
    private Integer habitId;
}
