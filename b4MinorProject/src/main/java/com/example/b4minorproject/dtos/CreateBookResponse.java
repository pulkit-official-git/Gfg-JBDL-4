package com.example.b4minorproject.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookResponse {

    private Integer id;

    private Date createdOn;
}
