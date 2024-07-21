package com.example.dailytracker.repository;

import com.example.dailytracker.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit,Integer> {
    List<Habit> findAllByUserUserId(int userId);

}
