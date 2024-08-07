package com.example.dailytracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "habit")
@Data
@ToString(exclude = {"user", "completions"})
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habitId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(nullable = false, length = 255)
    private String habitName;

    @Column(nullable = false, length = 50)
    private String frequency;

    @OneToMany(mappedBy = "habit", cascade = {CascadeType.REMOVE, CascadeType.DETACH}, orphanRemoval = true)
    private List<HabitCompletion> completions;
}
