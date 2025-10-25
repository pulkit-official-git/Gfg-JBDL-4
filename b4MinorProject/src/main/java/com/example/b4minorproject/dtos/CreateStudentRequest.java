package com.example.b4minorproject.dtos;

import com.example.b4minorproject.models.Gender;
import com.example.b4minorproject.models.Student;
import com.example.b4minorproject.models.StudentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    private StudentStatus status = StudentStatus.ACTIVE;

    @NonNull
    private Gender gender;

    public Student toStudent(){
        return Student
                .builder()
                .name(name)
                .email(email)
                .status(status)
                .gender(gender)
                .build();
    }


}
