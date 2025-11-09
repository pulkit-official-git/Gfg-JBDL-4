package com.example.b4minorproject.services;

import com.example.b4minorproject.models.Author;
import com.example.b4minorproject.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    public Author createAuthor(Author author) {
       return authorRepository.save(author);
    }
}
