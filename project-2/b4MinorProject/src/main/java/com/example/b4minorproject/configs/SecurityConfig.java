package com.example.b4minorproject.configs;


import com.example.b4minorproject.models.Authority;
import com.example.b4minorproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(UserService userService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/admin/**").hasAuthority(Authority.ADMIN.name())
                        .requestMatchers("/student/create").permitAll()
                        .requestMatchers("/book/create").hasAuthority(Authority.ADMIN.name())
                        .requestMatchers("/book/**").hasAnyAuthority(Authority.ADMIN.name(), Authority.STUDENT.name())
                        .requestMatchers("/student/admin/**").hasAuthority(Authority.ADMIN.name())
                        .requestMatchers("/student/**").hasAuthority(Authority.STUDENT.name())
                        .requestMatchers("/txn/**").hasAuthority(Authority.STUDENT.name())


                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
