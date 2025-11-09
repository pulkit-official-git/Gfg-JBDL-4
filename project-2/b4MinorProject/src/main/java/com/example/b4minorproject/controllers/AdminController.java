package com.example.b4minorproject.controllers;


import com.example.b4minorproject.dtos.CreateAdminRequest;
import com.example.b4minorproject.dtos.CreateStudentRequest;
import com.example.b4minorproject.dtos.CreateStudentResponse;
import com.example.b4minorproject.services.AdminService;
import com.example.b4minorproject.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Long create(@Valid @RequestBody CreateAdminRequest createAdminRequest){
        return this.adminService.create(createAdminRequest.toAdmin());
    }
}
