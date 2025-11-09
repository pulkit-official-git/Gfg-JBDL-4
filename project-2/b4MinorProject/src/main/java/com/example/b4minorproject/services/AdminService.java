package com.example.b4minorproject.services;

import com.example.b4minorproject.models.Admin;
import com.example.b4minorproject.models.Authority;
import com.example.b4minorproject.models.User;
import com.example.b4minorproject.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserService userService;

    public Long create(Admin admin) {
        User user = admin.getUser();
        user = this.userService.createUser(user, Authority.ADMIN);
        admin.setUser(user);
        this.adminRepository.save(admin);
        return admin.getId();
    }
}
