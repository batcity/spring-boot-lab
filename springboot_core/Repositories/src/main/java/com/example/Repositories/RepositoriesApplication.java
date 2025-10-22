package com.example.Repositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// TODO: look into connecting this to an in-memory database like h2
@SpringBootApplication
public class RepositoriesApplication {

    public static void main(String args[]) {
        SpringApplication.run(RepositoriesApplication.class, args);
    }
}


@RestController
class WordController {

    @GetMapping("/hello")
    public String printHello() {
        return "hello";
    }
}
