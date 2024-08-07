package com.example.dailytracker.repository;


import com.example.dailytracker.entity.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface HabitCompletionRepository extends JpaRepository<HabitCompletion, Integer> {
    void deleteByHabitHabitIdAndDateCompleted(int habitId, Date dateCompleted);

    boolean existsByHabitHabitIdAndDateCompleted(Integer habitId, Date date);
}
