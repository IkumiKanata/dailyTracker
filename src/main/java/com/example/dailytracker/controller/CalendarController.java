package com.example.dailytracker.controller;

import com.example.dailytracker.entity.Habit;
import com.example.dailytracker.service.CalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping
    public List<Habit> getCalendar(
            @RequestParam(value = "userId", required = true) Integer userId
    ) {
        return calendarService.getCalendars(userId);
    }


}
