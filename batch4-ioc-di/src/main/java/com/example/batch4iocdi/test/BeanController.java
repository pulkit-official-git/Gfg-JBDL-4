package com.example.batch4iocdi.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
public class BeanController {

//    @Value("${test.string.val}")
    private String testS;

//    @Value("${test.int.val}")
    private Integer testI;

//    @Value("${test.float.val}")
    private Float testF;

    private String testS2;

    public BeanController(@Qualifier("testString") String testS2, @Qualifier("testInt") Integer testI, Float testF) {
        this.testS = testS2;
        this.testI = testI;
        this.testF = testF;
    }
//    public BeanController(@Value("${test.string.val}") String testString,@Value("${test.int.val}") Integer testInt,@Value("${test.float.val}") Float testFloat) {
//        this.testString = testString;
//        this.testInt = testInt;
//        this.testFloat = testFloat;
//    }

    @GetMapping("/bean")
    public HashMap<String, Object> getV(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("testString", testS);
        map.put("testInt", testI);
        map.put("testFloat", testF);
        return map;
    }
}
