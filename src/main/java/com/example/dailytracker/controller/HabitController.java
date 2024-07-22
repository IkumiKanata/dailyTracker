package com.example.dailytracker.controller;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.model.CreateHabitRequest;
import com.example.dailytracker.model.HabitCompleteRequest;
import com.example.dailytracker.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<Habit> getHabits(
            @RequestParam(value = "userId") Integer userId) {
        return habitService.getUserHabits(userId);
    }

    @PostMapping
    public List<Habit> createHabit(
            @RequestBody CreateHabitRequest request) {
        habitService.createHabit(request.getUserId(), request.getHabitName());
        return habitService.getUserHabits(request.getUserId());
    }

    @DeleteMapping
    public void deleteHabit(
            @RequestParam(value = "habitId") Integer habitId) {
        habitService.deleteHabit(habitId);
    }

    @PostMapping("/complete")
    public List<Habit> markHabitComplete(
            @RequestBody HabitCompleteRequest request) {
        return habitService.markHabitComplete(request.getUserId(), request.getHabitId());
    }
}


