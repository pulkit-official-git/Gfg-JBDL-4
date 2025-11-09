package com.example.b4minorproject.repositories;

import com.example.b4minorproject.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
