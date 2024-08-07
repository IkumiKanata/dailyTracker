package com.example.dailytracker.service;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.entity.HabitCompletion;
import com.example.dailytracker.repository.HabitCompletionRepository;
import com.example.dailytracker.repository.HabitRepository;
import com.example.dailytracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

import static java.sql.Date.valueOf;

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

    public Page<Habit> getUserHabits(int userId, Pageable pageable) {
        return habitRepository.findAllByUserUserId(userId, pageable);
    }

    @Transactional
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

    @Transactional
    public void markHabitComplete(Integer userId, Integer habitId) {
        var user = userRepository.findById(userId).orElseThrow();
        var habit = habitRepository.findById(habitId).orElseThrow();
        if (habitCompletionRepository.existsByHabitHabitIdAndDateCompleted(habitId, new Date())) {
            return;
        }
        HabitCompletion habitCompletion = new HabitCompletion();
        habitCompletion.setHabit(habit);
        habitCompletion.setDateCompleted(new Date());
        habitCompletionRepository.save(habitCompletion);
    }


    @Transactional
    public void undoHabitComplete(Integer habitId) {
        LocalDate today = LocalDate.now();  // システムデフォルトのタイムゾーンで今日の日付を取得
        habitCompletionRepository.deleteByHabitHabitIdAndDateCompleted(habitId, valueOf(today));
    }

    @Transactional
    public void updateHabitTitle(Integer habitId, String habitName) {
        var habit = habitRepository.findById(habitId).orElseThrow();
        habit.setHabitName(habitName);
        habitRepository.save(habit);
    }

    @Transactional
    public void updateHabitFrequency(Integer habitId, String frequency) {
        var habit = habitRepository.findById(habitId).orElseThrow();
        habit.setFrequency(frequency);
        habitRepository.save(habit);
    }
}
