package com.example.b4minorproject.repositories;

import com.example.b4minorproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
