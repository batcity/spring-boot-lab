package com.example.jwtdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
class JWTIssuerController {

    public static void main(String args[]) {
        SpringApplication.run(JWTIssuerController.class, args);
    }


    @GetMapping
    public String login() {
        return "stub";
    }
}