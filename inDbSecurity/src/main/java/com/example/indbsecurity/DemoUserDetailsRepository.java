package com.example.indbsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface DemoUserDetailsRepository extends JpaRepository<DemoUser,Long> {

    UserDetails findByUsername(String username);
}
