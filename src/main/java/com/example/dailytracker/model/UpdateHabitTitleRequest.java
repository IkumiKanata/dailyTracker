package com.example.dailytracker.model;

import lombok.Data;

@Data
public class UpdateHabitTitleRequest {
    private Integer habitId;
    private String habitName;
}
