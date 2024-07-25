package com.example.dailytracker.controller;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.model.CreateHabitRequest;
import com.example.dailytracker.model.HabitCompleteRequest;
import com.example.dailytracker.model.UpdateHabitTitleRequest;
import com.example.dailytracker.service.HabitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habit")
@CrossOrigin
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public Page<Habit> getHabits(
            @RequestParam(value = "userId") Integer userId, Pageable pageable) {
        return habitService.getUserHabits(userId, pageable);
    }

    @PostMapping
    public void createHabit(
            @RequestBody CreateHabitRequest request) {
        habitService.createHabit(request.getUserId(), request.getHabitName());
    }

    @DeleteMapping
    public void deleteHabit(
            @RequestParam(value = "habitId") Integer habitId) {
        habitService.deleteHabit(habitId);
    }

    @PostMapping("/complete")
    public void markHabitComplete(
            @RequestBody HabitCompleteRequest request) {
        habitService.markHabitComplete(request.getUserId(), request.getHabitId());
    }

    @DeleteMapping("/complete")
    public void undoHabitComplete(
            @RequestParam(value = "habitId") Integer habitId) {
        habitService.undoHabitComplete(habitId);
    }

    @PutMapping
    public void updateHabitTitle(
            @RequestBody UpdateHabitTitleRequest request) {
        habitService.updateHabitTitle(request.getHabitId(), request.getHabitName());
    }
}


