package com.example.batch4bookmanagementsystem;

import com.example.batch4bookmanagementsystem.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Integer create(Book book) throws SQLException {
            this.bookRepository.createBook(book);
            return book.getId();
    }

    public List<Book> getAll() throws SQLException {
        return this.bookRepository.getAll();
    }

    public Book getBookById(Integer id) throws SQLException {
        return this.bookRepository.getById(id);
    }

    public Book update(Book book,Integer id) throws SQLException {
         this.bookRepository.update(book,id);
         return getBookById(id);
    }
}
