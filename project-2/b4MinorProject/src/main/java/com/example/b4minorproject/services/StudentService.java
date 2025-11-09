package com.example.b4minorproject.services;

import com.example.b4minorproject.dtos.CreateBookResponse;
import com.example.b4minorproject.dtos.CreateStudentResponse;
import com.example.b4minorproject.dtos.GetStudentResponse;
import com.example.b4minorproject.models.Authority;
import com.example.b4minorproject.models.Student;
import com.example.b4minorproject.models.StudentStatus;
import com.example.b4minorproject.models.User;
import com.example.b4minorproject.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    public CreateStudentResponse create(Student student) {

        User user = student.getUser();
        user = this.userService.createUser(user, Authority.STUDENT);
        student.setUser(user);
        Student savedStudent = this.studentRepository.save(student);
        return CreateStudentResponse.builder().student(savedStudent).build();

        /*
        * 1. from student get user
        * 2. set authority in user
        * 3. encode the password
        * 4. save user
        * 5. save student
        *
        * */

//      Below code works in spring 3
//        this.studentRepository.save(student);
//        return CreateStudentResponse.builder().student(student).build();


    }

    public CreateStudentResponse get(Integer id) {
        Student student = this.studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }
        return CreateStudentResponse.builder().student(student).build();
    }

    public CreateStudentResponse update(Student student, Integer id) {

        Student existingStudent = this.studentRepository.findById(id).orElse(null);
        if (existingStudent == null) {
            return null;
        }
        Student updatedStudent = this.merge(existingStudent,student);
        Student mergedStudent = this.studentRepository.save(updatedStudent);
        return CreateStudentResponse.builder().student(mergedStudent).build();


    }

    private Student merge(Student existingStudent, Student student) {
        HashMap<String,Object> existing = this.objectMapper.convertValue(existingStudent,HashMap.class);
        HashMap<String,Object> incoming = this.objectMapper.convertValue(student,HashMap.class);

        for(String fieldName : incoming.keySet()) {
            if(incoming.get(fieldName) != null) {
                existing.put(fieldName, incoming.get(fieldName));
            }
        }

        Student mergedStudent = this.objectMapper.convertValue(existing,Student.class);
        return mergedStudent;
    }

    public void deactivate(Integer id) {

        Student student = this.studentRepository.findById(id).orElse(null);
        if (student == null) {
            return;
        }

        this.studentRepository.deactivate(id, StudentStatus.INACTIVE);
    }
}
