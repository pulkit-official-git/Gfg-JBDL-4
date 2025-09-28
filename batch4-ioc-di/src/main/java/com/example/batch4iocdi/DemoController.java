package com.example.batch4iocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "prototype")
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    Person p;

    DemoController(){
        logger.info("inside DemoController {}",this);
    }

    @GetMapping("/demo")
    public String hello() {
//        Person person = new Person();
        logger.info("inside DemoController {}",this.p);
        this.p.age=5;
        this.p.name="hello";
        logger.info("inside DemoController {}",this.p);
        return "Hello World";
    }
}
