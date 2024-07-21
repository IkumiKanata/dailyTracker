package com.example.dailytracker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "habit_completion")
@Data
@ToString(exclude = {"habit", "user"})
public class HabitCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCompleted;
}
