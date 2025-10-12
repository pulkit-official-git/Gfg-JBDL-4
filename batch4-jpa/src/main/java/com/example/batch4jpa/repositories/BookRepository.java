package com.example.batch4jpa.repositories;

import com.example.batch4jpa.models.Book;
import com.example.batch4jpa.models.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query(value = "select * from book b where b.id = :genre",nativeQuery = true)
//    Book getByGenre(Genre genre);

    @Query(value = "select * from book b where b.genre = ?1",nativeQuery = true)
    List<Book> getByGenreNative(Genre genre);

    @Query("select b from Book b where b.genre = :genre")
    List<Book> getByGenreJPQL(Genre genre);

    List<Book> findByGenreAndName(Genre genre, String name);

    List<Book> findByGenreOrName(Genre genre, String name);

    @Transactional
    @Modifying
    @Query("update Book b set b.genre=?1 where b.id = ?2")
    void updateGenreById(Genre genre, Integer id);
}
