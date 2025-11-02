package com.example.batch4redis.controllers;

import com.example.batch4redis.dtos.CreatePersonRequest;
import com.example.batch4redis.models.Person;
import com.example.batch4redis.services.StringValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/string")
public class StringValueController {

    @Autowired
    StringValueService stringValueService;


    @PostMapping("/create")
    public Person create(@RequestBody CreatePersonRequest createPersonRequest){
        return this.stringValueService.create(createPersonRequest.toPerson());
    }

    @GetMapping("/get")
    public Person get(@RequestParam String id){
        return this.stringValueService.get(id);
    }
}
