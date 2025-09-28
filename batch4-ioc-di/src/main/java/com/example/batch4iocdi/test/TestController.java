package com.example.batch4iocdi.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestConfg testConfg;

//    @Autowired


//    @Autowired
    private  DemoRepository demoRepository;

//    @Autowired
    private DemoService demoService;

//    @Autowired
    TestController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
//        this.demoService = demoService;
//        System.out.println(this.demoService);
//        System.out.println(this.demoRepository);
        this.demoRepository.a=5;
        System.out.println(demoRepository.a);
    }

    @Autowired
    TestController(DemoService demoService) {
        this.demoService = demoService;
//        this.demoService = demoService;
//        System.out.println(this.demoService);
//        System.out.println(this.demoRepository);
//        this.demoRepository.a=5;
//        System.out.println(demoRepository.a);
    }

    @GetMapping("/hell")
    public String hello(){
        System.out.println(this.testConfg.objectMapper());
        return "Hello ";
    }
}
