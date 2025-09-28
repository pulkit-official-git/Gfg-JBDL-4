package com.example.batch4iocdi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@Scope(value = "prototype")
public class TestConfg {


    @Bean
//    @Scope(value = "prototype")
    public ObjectMapper  objectMapper() {
        return new ObjectMapper();
    }


}
