package com.example.dailytracker.service;

import com.example.dailytracker.entity.Role;
import com.example.dailytracker.entity.User;
import com.example.dailytracker.model.LoginUserResponse;
import com.example.dailytracker.repository.RoleRepository;
import com.example.dailytracker.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
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

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
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

    public LoginUserResponse loginUser(String username, String password) {

        try {
            var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var token = tokenService.generateJwt(auth);
            var user = userRepository.findByUsername(username).get();
            return new LoginUserResponse(user, token);
        } catch (AuthenticationException e) {
            return new LoginUserResponse(null, "");
        }
    }


}
