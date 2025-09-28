package com.example.batch4bookmanagementsystem;

import com.example.batch4bookmanagementsystem.models.Book;
import jakarta.validation.Valid;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Integer createBook(@Valid @RequestBody CreateBookRequestDto createBookRequestDto) throws SQLException {
        return this.bookService.create(createBookRequestDto.toBook());
    }

    @GetMapping("/get/all")
    public List<Book> getBooks() throws SQLException {
        return this.bookService.getAll();
    }

    @GetMapping("/get/id/{id}")
    public Book getBookById(@PathVariable("id") Integer id) throws SQLException {
        return this.bookService.getBookById(id);
    }

    @PatchMapping("/update")
    public Book update(@RequestBody CreateBookRequestDto createBookRequestDto,
                       @RequestParam Integer id) throws SQLException {
        return this.bookService.update(createBookRequestDto.toBook(),id);
    }
}
