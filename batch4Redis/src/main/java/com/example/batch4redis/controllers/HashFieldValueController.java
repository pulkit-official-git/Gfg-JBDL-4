package com.example.batch4redis.controllers;

import com.example.batch4redis.dtos.CreatePersonRequest;
import com.example.batch4redis.models.Person;
import com.example.batch4redis.services.HashFieldValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hash")
public class HashFieldValueController {

    @Autowired
    private HashFieldValueService hashFieldValueService;

    @PostMapping("/create")
    public Person create(@RequestBody CreatePersonRequest createPersonRequest){
        return this.hashFieldValueService.create(createPersonRequest.toPerson());
    }

    @GetMapping("/get")
    public Person get(@RequestParam String id){
        return this.hashFieldValueService.getAll(id);
    }

    @GetMapping("/getFl")
    public Object getFl(@RequestParam String id,
                        @RequestParam String field){
        return this.hashFieldValueService.getF(id,field);
    }
}
