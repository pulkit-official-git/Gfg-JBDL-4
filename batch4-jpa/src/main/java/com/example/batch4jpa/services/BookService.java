package com.example.batch4jpa.services;


import com.example.batch4jpa.models.Book;
import com.example.batch4jpa.models.Genre;
import com.example.batch4jpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Integer create(Book book) {
        this.bookRepository.save(book);
        return book.getId();
    }

    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return this.bookRepository.findById(id).orElse(null);
    }

//    public Book getBookByGenre(Genre genre) {
//        return this.bookRepository.getByGenre(genre);
//    }

    public List<Book> getBookByGenreNative(Genre genre) {
        return this.bookRepository.getByGenreNative(genre);
    }

    public List<Book> getBookByGenreJPQL(Genre genre) {
        return this.bookRepository.getByGenreJPQL(genre);
    }

    public List<Book> getBookByGenreAndName(Genre genre,String name) {
        return this.bookRepository.findByGenreAndName(genre,name);
    }

    public void UpdateGenreById(Genre genre, Integer id) {
        this.bookRepository.updateGenreById(genre,id);
    }
}
