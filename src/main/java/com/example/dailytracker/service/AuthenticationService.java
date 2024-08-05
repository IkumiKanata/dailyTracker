package com.example.dailytracker.service;

import com.example.dailytracker.entity.Role;
import com.example.dailytracker.entity.User;
import com.example.dailytracker.repository.RoleRepository;
import com.example.dailytracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String email, String password) {
        var userRole = roleRepository.findByAuthority("ROLE_USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        User user = new User();


        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthorities(authorities);
        return userRepository.save(user);
    }


}
