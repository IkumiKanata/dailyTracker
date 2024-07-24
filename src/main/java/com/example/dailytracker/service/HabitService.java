package com.example.dailytracker.service;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.entity.HabitCompletion;
import com.example.dailytracker.repository.HabitCompletionRepository;
import com.example.dailytracker.repository.HabitRepository;
import com.example.dailytracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitCompletionRepository habitCompletionRepository;

    private final UserRepository userRepository;

    public HabitService(HabitRepository habitRepository, HabitCompletionRepository habitCompletionRepository, UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.habitCompletionRepository = habitCompletionRepository;
        this.userRepository = userRepository;
    }

    public Map<Integer, Habit> getUserHabits(int userId) {
        var habits = habitRepository.findAllByUserUserId(userId);
        return habits.stream().collect(Collectors.toMap(Habit::getHabitId, Function.identity()));

    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public void deleteHabit(int habitId) {
        habitRepository.deleteById(habitId);
    }


    @Transactional
    public void createHabit(Integer userId, String habitName) {
        var user = userRepository.findById(userId).orElseThrow();
        Habit habit = new Habit();
        habit.setHabitName(habitName);
        habit.setUser(user);
        habit.setFrequency("daily");
        habitRepository.save(habit);
    }

    public List<Habit> markHabitComplete(Integer userId, Integer habitId) {
        var user = userRepository.findById(userId).orElseThrow();
        var habit = habitRepository.findById(habitId).orElseThrow();
        HabitCompletion habitCompletion = new HabitCompletion();
        habitCompletion.setUser(user);
        habitCompletion.setHabit(habit);
        habitCompletion.setDateCompleted(new Date());
        habitCompletionRepository.save(habitCompletion);
        return habitRepository.findAllByUserUserId(habit.getUser().getUserId());
    }
}
