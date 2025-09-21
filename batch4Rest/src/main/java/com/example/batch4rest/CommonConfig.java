package com.example.batch4rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {


//    @Value("${library.books}")
//    Integer libraryBooks;


    @Bean
    public ObjectMapper get() {
        return new ObjectMapper();
    }

//    @Bean
//    public Integer get(){
//        return libraryBooks;
//    }
}
