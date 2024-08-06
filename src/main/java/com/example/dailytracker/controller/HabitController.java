package com.example.dailytracker.controller;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.model.CreateHabitRequest;
import com.example.dailytracker.model.HabitCompleteRequest;
import com.example.dailytracker.model.UpdateHabitTitleRequest;
import com.example.dailytracker.service.HabitService;
import com.example.dailytracker.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/habit")
@CrossOrigin
public class HabitController {

    private final HabitService habitService;

    private final UserService userService;

    public HabitController(HabitService habitService, UserService userService) {
        this.habitService = habitService;
        this.userService = userService;
    }

    @GetMapping
    public Page<Habit> getHabits(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = userService.extractUserIdFromAuthentication(authentication);
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

    @PutMapping("/frequency")
    public void updateHabitFrequency(
            @RequestParam(value = "habitId") Integer habitId,
            @RequestParam(value = "frequency") String frequency) {
        habitService.updateHabitFrequency(habitId, frequency);
    }
}


