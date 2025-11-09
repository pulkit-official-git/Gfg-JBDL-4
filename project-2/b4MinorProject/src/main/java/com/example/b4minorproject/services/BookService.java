package com.example.b4minorproject.services;

import com.example.b4minorproject.dtos.CreateBookResponse;
import com.example.b4minorproject.models.Author;
import com.example.b4minorproject.models.Book;
import com.example.b4minorproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public CreateBookResponse createBook(Book book) {
        Author author = book.getAuthor();
        author = this.authorService.createAuthor(author);
        book.setAuthor(author);
        book = bookRepository.save(book);
        return CreateBookResponse.builder()
                .id(book.getId())
                .createdOn(book.getCreatedOn())
                .build();
    }

    public Book getBook(Integer id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return this.bookRepository.save(book);
    }
}
