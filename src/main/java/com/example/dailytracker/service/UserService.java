package com.example.dailytracker.service;

import com.example.dailytracker.entity.Role;
import com.example.dailytracker.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder encoder;

    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Username: " + username);

        if (!username.equals("Kanata")) throw new UsernameNotFoundException("User not found");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, " USER"));
        return new User(100, "Kanata", "test.com", encoder.encode("password"), roles);
    }
}
