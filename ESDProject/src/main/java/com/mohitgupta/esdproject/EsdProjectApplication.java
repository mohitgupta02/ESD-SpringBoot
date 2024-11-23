package com.mohitgupta.esdproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EsdProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdProjectApplication.class, args);
    }

}
