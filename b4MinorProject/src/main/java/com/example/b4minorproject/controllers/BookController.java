package com.example.b4minorproject.controllers;

import com.example.b4minorproject.dtos.CreateBookRequest;
import com.example.b4minorproject.dtos.CreateBookResponse;
import com.example.b4minorproject.dtos.GetBookResponse;
import com.example.b4minorproject.models.Book;
import com.example.b4minorproject.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public CreateBookResponse createBook(@Valid @RequestBody CreateBookRequest createBookRequest){
        return this.bookService.createBook(createBookRequest.toBook());
    }

    @GetMapping("/get")
    public Book getBook(@RequestParam("id") Integer id){
        return this.bookService.getBook(id);
    }
}
