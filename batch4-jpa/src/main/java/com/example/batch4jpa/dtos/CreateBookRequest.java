package com.example.batch4jpa.dtos;


import com.example.batch4jpa.models.Book;
import com.example.batch4jpa.models.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @Length(min=1, max=100)
    private String name;

    private String author;

    @NotNull
    private Genre genre;

    private Double price;

    public Book toBook(){
        return Book.builder()
                .name(name)
                .author(author)
                .genre(genre)
                .price(price)
//                .createdOn(new Date())
//                .updatedOn(new Date())
                .build();
    }
}
