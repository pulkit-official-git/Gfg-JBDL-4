package com.example.batch4jpa.controllers;

import com.example.batch4jpa.dtos.CreateBookRequest;
import com.example.batch4jpa.models.Book;
import com.example.batch4jpa.models.Genre;
import com.example.batch4jpa.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Integer createBook(@Valid @RequestBody CreateBookRequest createBookRequestDto) {
        return this.bookService.create(createBookRequestDto.toBook());
//        return 0;
    }

    @GetMapping("/get/all")
    public List<Book> getBooks() {
        return this.bookService.getAll();
    }
//
    @GetMapping("/get/id/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return this.bookService.getBookById(id);
    }

    @GetMapping("/get/genre/{genre}/native")
    public List<Book> getBookByGenreNative(@PathVariable("genre") Genre genre) {
        return this.bookService.getBookByGenreNative(genre);
    }

    @GetMapping("/get/genre/{genre}/jpql")
    public List<Book> getBookByGenreJPQL(@PathVariable("genre") Genre genre) {
        return this.bookService.getBookByGenreJPQL(genre);
    }

    @GetMapping("/get/genre/{genre}/name/{name}")
    public List<Book> getBookByGenreAndName(@PathVariable("genre") Genre genre,
                                         @PathVariable("name") String name) {
        return this.bookService.getBookByGenreAndName(genre,name);
    }

    @PatchMapping("/update/genre/{genre}/id/{id}")
    public void UpdateGenreById(@PathVariable("genre") Genre genre,
                                            @PathVariable("id") Integer id) {
        this.bookService.UpdateGenreById(genre,id);
    }


}
