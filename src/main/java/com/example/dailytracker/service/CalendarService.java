package com.example.dailytracker.service;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.repository.HabitCompletionRepository;
import com.example.dailytracker.repository.HabitRepository;
import com.example.dailytracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    private final UserRepository userRepository;
    private final HabitRepository habitRepository;
    private final HabitCompletionRepository habitCompletionRepository;

    public CalendarService(UserRepository userRepository, HabitRepository habitRepository, HabitCompletionRepository habitCompletionRepository) {
        this.userRepository = userRepository;
        this.habitRepository = habitRepository;
        this.habitCompletionRepository = habitCompletionRepository;
    }

    public List<Habit> getCalendars(int userId) {
        return habitRepository.findAllByUserUserId(userId);
    }

}
