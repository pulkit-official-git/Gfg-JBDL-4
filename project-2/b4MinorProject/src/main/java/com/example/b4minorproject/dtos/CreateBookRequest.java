package com.example.b4minorproject.dtos;

import com.example.b4minorproject.models.Author;
import com.example.b4minorproject.models.Book;
import com.example.b4minorproject.models.Genre;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String authorName;

    @Email
    private String authorEmail;

    @NotBlank
    private String authorNumber;

    @NonNull
    private Genre genre;

    public Book toBook(){
        return Book
                .builder()
                .title(this.title)
                .genre(this.genre)
                .author(Author
                        .builder()
                        .name(this.authorName)
                        .email(this.authorEmail)
                        .number(this.authorNumber)
                        .build())
                .build();
    }
}


