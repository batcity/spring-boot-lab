package com.example.Controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ControllersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllersApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id) {
        return "Fetching user with ID: " + id;
    }
}