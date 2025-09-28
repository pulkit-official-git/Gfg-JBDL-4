package com.example.batch4bookmanagementsystem.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Qualifier
public class Book {

    private Integer id;

    private String name;

    private String author;

    private Genre genre;

    private Double price;

    private Date createdOn;

    private Date updatedOn;

}
