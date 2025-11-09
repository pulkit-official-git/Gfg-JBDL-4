package com.example.b4minorproject.repositories;

import com.example.b4minorproject.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Integer> {
}
