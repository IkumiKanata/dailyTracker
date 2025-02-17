//package com.example.dailytracker.service;
//
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.util.stream.Collectors;
//
//@Service
//public class TokenService {
//
//    private final JwtEncoder jwtEncoder;
//
//    public TokenService(JwtEncoder jwtEncoder) {
//        this.jwtEncoder = jwtEncoder;
//    }
//
//    public String generateJwt(Authentication auth) {
//        Instant now = Instant.now();
//        String scope = auth.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
//        JwtClaimsSet claims = JwtClaimsSet.builder()
//                .issuer("daily-tracker")
//                .subject(auth.getName())
//                .issuedAt(now)
//                .claim("roles", scope)
//                .claim("userId", 1)
//
//                .build();
//        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
//    }
//}
