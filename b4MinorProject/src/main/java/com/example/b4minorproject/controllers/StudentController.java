package com.example.b4minorproject.controllers;

import com.example.b4minorproject.dtos.CreateStudentRequest;
import com.example.b4minorproject.dtos.CreateStudentResponse;
import com.example.b4minorproject.dtos.GetStudentResponse;
import com.example.b4minorproject.dtos.UpdateStudentRequest;
import com.example.b4minorproject.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public CreateStudentResponse create(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        return this.studentService.create(createStudentRequest.toStudent());
    }

    @GetMapping("/get")
    public CreateStudentResponse get(@RequestParam("id") Integer id){
        return this.studentService.get(id);
    }

    @PatchMapping("/patch")
    public CreateStudentResponse update(@Valid @RequestBody UpdateStudentRequest updateStudentRequest,
                                        @RequestParam("id") Integer id){
        return this.studentService.update(updateStudentRequest.toStudent(),id);
    }

    @DeleteMapping("/deactivate")
    public void deactivate(@RequestParam("id") Integer id){
        this.studentService.deactivate(id);
    }

}
