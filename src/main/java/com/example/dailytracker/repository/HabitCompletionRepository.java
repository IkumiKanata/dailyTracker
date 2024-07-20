package com.example.dailytracker.repository;


import com.example.dailytracker.entity.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitCompletionRepository extends JpaRepository<HabitCompletion,Integer> {
}
