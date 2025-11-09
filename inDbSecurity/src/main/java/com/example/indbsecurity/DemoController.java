package com.example.indbsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    @GetMapping("/demo")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/user/demo")
    public String userHello(){
        return "Hello User";
    }

    @GetMapping("/admin/demo")
    public String adminHello(){
        return "Hello Admin";
    }

    @PostMapping("/user/signup")
    public void signup(@RequestParam String username, @RequestParam String password){
        DemoUser demoUser = DemoUser
                .builder()
                .username(username)
                .password(password)
                .authorities("USER")
                .build();

        this.demoUserDetailsService.createUser(demoUser);

    }

    @PostMapping("/admin/signup")
    public void adminSignup(@RequestParam String username, @RequestParam String password){
        DemoUser demoUser = DemoUser
                .builder()
                .username(username)
                .password(password)
                .authorities("ADMIN")
                .build();

        this.demoUserDetailsService.createUser(demoUser);

    }
}
