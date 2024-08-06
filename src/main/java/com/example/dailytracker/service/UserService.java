package com.example.dailytracker.service;

import com.example.dailytracker.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
public class UserService implements UserDetailsService {

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public Integer extractUserIdFromAuthentication(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("認証情報が不正です。");
        }

        log.warn("Authentication: {}", authentication);
        log.warn("Principal: {}", authentication.getPrincipal());

        var test = authentication.getDetails();

        Object principal = authentication.getPrincipal();

        if (authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            Map<String, Object> claims = jwt.getClaims();
            // 全てのクレームをログ出力
            claims.forEach((key, value) -> {
                log.info("Claim {} : {}", key, value);
            });
        }
//        if (principal instanceof UserDetails userDetails) {
//            // UserDetailsからユーザーIDを抽出する方法は、実装に依存します。
//            return ((User) userDetails).getUserId();
//        } else if (principal instanceof Jwt jwt) {
//            // JWTからユーザーIDを抽出するためのクレーム名を指定します。
//            return jwt.getClaim("user_id");
//        } else {
//            throw new IllegalStateException("認証情報の型が予期されたものと異なります。");
//        }
        return 0;
    }
}
