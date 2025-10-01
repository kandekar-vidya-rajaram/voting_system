//package com.project.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable() // disable CSRF for simplicity
//            .authorizeHttpRequests()
//            .requestMatchers("/api/users/register", "/api/users/login").permitAll() // public endpoints
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic(); // keep basic auth enabled for now
//
//        return http.build();
//    }
//}

package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()       // Disable CSRF for testing with Postman
            .authorizeHttpRequests()
            .anyRequest().permitAll(); // Allow all requests without authentication
        return http.build();
    }
}
