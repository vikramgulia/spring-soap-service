package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    ConfigurableApplicationContext cac;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}