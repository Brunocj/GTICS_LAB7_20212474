package com.example.lab7gtics.config;

import com.example.lab7gtics.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   UserRepository userRepository) throws Exception {
        http.formLogin().loginPage("/openLoginWindow").loginProcessingUrl("/submitLoginForm").successHandler(new CustomAuthenticationSuccessHandler());
        http.authorizeHttpRequests()
                .requestMatchers("/admin", "/admin/**").hasAnyAuthority("ADMIN")
                .requestMatchers("/Gerente", "/Gerente/**").hasAnyAuthority("GERENTE")
                .requestMatchers("/cliente", "/cliente/**").hasAnyAuthority("CLIENTE")
                .anyRequest().permitAll();
        http.logout();


        return http.build();
    }



}
