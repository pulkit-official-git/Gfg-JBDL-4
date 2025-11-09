package com.example.testb4indb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    DemoUserDetailsRepository demoUserDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.demoUserDetailsRepository.findByUsername(username);
    }

    public void createUser(DemoUser demoUser) {
        demoUser.setPassword(passwordEncoder.encode(demoUser.getPassword()));
        this.demoUserDetailsRepository.save(demoUser);
    }
}
