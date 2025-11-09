package com.example.b4minorproject.dtos;

import com.example.b4minorproject.models.Student;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentResponse {

    private Student student;
}
