package com.example.batch4profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Batch4ProfilesApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(Batch4ProfilesApplication.class);

    @Value("${spring.datasource.url}")
    String url;

    @Value("${paytm.users}")
    String users;

    public static void main(String[] args) {
        SpringApplication.run(Batch4ProfilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(url);
        logger.debug("Running Batch4ProfilesApplication with url and users {},{}",url,users);
//        System.out.println(users);
    }
}
