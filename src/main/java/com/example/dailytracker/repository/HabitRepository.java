package com.example.dailytracker.repository;

import com.example.dailytracker.entity.Habit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {
    Page<Habit> findAllByUserUserId(int userId, Pageable pageable);
}
