package com.example.b4minorproject.dtos;


import com.example.b4minorproject.models.Gender;
import com.example.b4minorproject.models.StudentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetStudentResponse {

    private Integer id;

    private String name;

    private String email;

    private StudentStatus status;

    private Gender gender;

}
