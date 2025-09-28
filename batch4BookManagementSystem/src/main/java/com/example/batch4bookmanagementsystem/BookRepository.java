package com.example.batch4bookmanagementsystem;

import com.example.batch4bookmanagementsystem.models.Book;
import com.example.batch4bookmanagementsystem.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private DatabaseRepository databaseRepository;


    BookRepository(DatabaseRepository databaseRepository) throws SQLException {
        this.databaseRepository = databaseRepository;
        createTable();
    }

//    private Connection getConnection() throws SQLException {
//        if(connection == null) {
//            connection= DriverManager.getConnection(this.url,this.username,this.password);
//        }
//        return connection;
//    }



    private void createTable() throws SQLException {
        String query = "create table if not exists book(id int primary key auto_increment,name varchar(50),author varchar(50),genre varchar(50),price double," +
                "createdOn datetime,updatedOn datetime)";
        Statement statement = this.databaseRepository.getConnection().createStatement();
        statement.execute(query);
    }

    public void createBook(Book book) throws SQLException {
//        prepared statement
        String query = "insert into book(name,author,genre,price,createdOn,updatedOn)" +
                "values(?,?,?,?,?,?)";

//        create statement
//        String query2 = "insert into book(name,author,genre,price,createdOn,updatedOn)" +
//                "values(book.getName(),book.getAuthor(),book.getGenre(),book.getPrice(),?,?,?)";
        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3,book.getGenre().name());
        preparedStatement.setDouble(4, book.getPrice());
        preparedStatement.setDate(5,new Date(book.getCreatedOn().getTime()));
        preparedStatement.setDate(6,new Date(book.getUpdatedOn().getTime()));
        preparedStatement.execute();
    }

    public List<Book> getAll() throws SQLException {
        String query = "select * from book";
        Statement statement = this.databaseRepository.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt(1));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setGenre(Genre.valueOf(resultSet.getString("genre")));
            book.setPrice(resultSet.getDouble("price"));
            book.setCreatedOn(resultSet.getDate("createdOn"));
            book.setUpdatedOn(resultSet.getDate("updatedOn"));
            books.add(book);
        }
        return books;


    }

    public Book getById(Integer id) throws SQLException {
        String query = "select * from book where id = ?";
        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book book = new Book();
        while(resultSet.next()) {
            book.setId(resultSet.getInt(1));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setGenre(Genre.valueOf(resultSet.getString("genre")));
            book.setPrice(resultSet.getDouble("price"));
            book.setCreatedOn(resultSet.getDate("createdOn"));
            book.setUpdatedOn(resultSet.getDate("updatedOn"));
        }
        return book;

    }

    public void update(Book incomingBook, Integer id) throws SQLException {
        Book existingBook = this.getById(id);
        String query = "update book set price = ?,genre = ?,author=? where id = ?";
        PreparedStatement preparedStatement = this.databaseRepository.getConnection().prepareStatement(query);
        if(incomingBook.getPrice()!=null) {
            preparedStatement.setDouble(1, incomingBook.getPrice());
        }
        else{
            preparedStatement.setDouble(1, existingBook.getPrice());
        }
        if(incomingBook.getGenre()!=null) {
            preparedStatement.setString(2, incomingBook.getGenre().name());
        }
        else{
            preparedStatement.setString(2, existingBook.getGenre().name());
        }
        if(incomingBook.getAuthor()!=null) {
            preparedStatement.setString(3, incomingBook.getAuthor());
        }
        else{
            preparedStatement.setString(3, existingBook.getAuthor());
        }
//        preparedStatement.setDouble(1, book.getPrice());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();
//        ResultSet resultSet=preparedStatement.executeQuery();
//        Book returnBook = new Book();
//        while(resultSet.next()) {
//            returnBook.setId(resultSet.getInt(1));
//            returnBook.setName(resultSet.getString("name"));
//            returnBook.setAuthor(resultSet.getString("author"));
//            returnBook.setGenre(Genre.valueOf(resultSet.getString("genre")));
//            returnBook.setPrice(resultSet.getDouble("price"));
//            returnBook.setCreatedOn(resultSet.getDate("createdOn"));
//            returnBook.setUpdatedOn(resultSet.getDate("updatedOn"));
//        }
//        return returnBook;


    }
}
