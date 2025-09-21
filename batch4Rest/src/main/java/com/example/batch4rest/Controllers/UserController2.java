package com.example.batch4rest.Controllers;

import com.example.batch4rest.Dtos.GetUserResponseDto;
import com.example.batch4rest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    @Autowired
    private static UserService userService;

//    public UserController2() {
//        userService = new UserService();
//    }


    @PostMapping("/user/get")
    public GetUserResponseDto getUser(@RequestParam("id") Integer id){
//        UserService userService = new UserService();
        return  userService.getUser(id);
    }
}
