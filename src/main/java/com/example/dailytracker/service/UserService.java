package com.example.dailytracker.service;

import com.example.dailytracker.entity.Role;
import com.example.dailytracker.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.example.dailytracker.util.PasswordUtil.encode;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Username: " + username);

        if (!username.equals("Kanata")) throw new UsernameNotFoundException("User not found");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, " USER"));
        return new User(100, "Kanata", "test.com", encode("password"), roles);
    }
}
