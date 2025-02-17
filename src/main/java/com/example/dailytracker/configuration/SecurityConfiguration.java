package com.example.dailytracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//    private final RsaKeyProperties keys;

//    public SecurityConfiguration(RsaKeyProperties keys) {
//        this.keys = keys;
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //@Serviceで登録されている UserService を AuthenticationManager に登録
    // DaoAuthenticationProvider は、UserDetailsService と PasswordEncoder を使用して認証を行う
    // DaoAuthenticationProvider は、 PasswordEncoder が明示的に設定されていない場合、DaoAuthenticationProvider はデフォルトの設定（もしあれば）を使用
//    @Bean
//    public AuthenticationManager authenticationManager(UserDetailsService detailsService) {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(detailsService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return new ProviderManager(provider);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/auth/**").permitAll();
//                    auth.requestMatchers("/admin/**").hasRole("ADMIN");
//                    auth.requestMatchers("/habit/**").hasAnyRole("USER", "ADMIN");
//                    auth.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN");
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer -> OAuth2ResourceServerConfigurer.jwt(jwt -> {
//                    jwt
//                            .decoder(jwtDecoder())
//                            .jwtAuthenticationConverter(jwtAuthenticationConverter());
//                }))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withPublicKey(this.keys.getPublicKey()).build();
//    }
//
//    @Bean
//    public JwtEncoder jwtEncoder() {
//        JWK jwk = new RSAKey.Builder(this.keys.getPublicKey())
//                .privateKey(this.keys.getPrivateKey())
//                .build();
//        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//        return new NimbusJwtEncoder(jwks);
//    }

//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
//        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
//
//        var jwtConverter = new JwtAuthenticationConverter();
//        jwtConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
//        return jwtConverter;
//    }
}
