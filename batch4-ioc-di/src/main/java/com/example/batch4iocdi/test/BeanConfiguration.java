package com.example.batch4iocdi.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Value("${test.string.val}")
    String testString;

    @Bean
    public String testString() {
        return testString;
    }

    @Bean
    public Integer testInt(@Value("${test.int.val}")Integer testInt) {
        return testInt;
    }

    @Bean
    public Float testFloat(@Value("${test.float.val}")Float testFloat) {
        return testFloat;
    }

    @Bean
    public String testString2(@Value("${test.string.val2}")String testString2) {
        return testString2;
    }
}
