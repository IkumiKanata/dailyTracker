package com.example.dailytracker.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

public class PasswordUtil {
    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static boolean match(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
