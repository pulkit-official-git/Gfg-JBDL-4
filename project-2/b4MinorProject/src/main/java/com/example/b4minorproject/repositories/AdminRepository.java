package com.example.b4minorproject.repositories;

import com.example.b4minorproject.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
