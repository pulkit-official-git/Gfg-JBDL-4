package com.example.batch4bookmanagementsystem;

import com.example.batch4bookmanagementsystem.models.Book;
import com.example.batch4bookmanagementsystem.models.Genre;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequestDto {

    @Length(min=1, max=100)
    private String name;

    private String author;

//    @NotBlank
    private Genre genre;

    private Double price;

    public Book toBook(){
        return Book.builder()
                .name(name)
                .author(author)
                .genre(genre)
                .price(price)
                .createdOn(new Date())
                .updatedOn(new Date())
                .build();
    }
}
