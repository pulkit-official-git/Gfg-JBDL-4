package com.example.batch4iocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    Person p;

    DemoController2(){
        logger.info("inside DemoController2 {}",this);
    }

    @GetMapping("/demo2")
    public String hello() {
//        Person person = new Person();
        logger.info("inside DemoController {}",this.p);
        this.p.age=10;
        this.p.name="hello 2";
        logger.info("inside DemoController {}",this.p);
        return "Hello World";
    }
}
