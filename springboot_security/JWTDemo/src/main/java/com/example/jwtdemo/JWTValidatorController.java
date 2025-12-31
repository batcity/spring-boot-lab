package com.example.jwtdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.security.Keys;

import java.security.Key;

@SpringBootApplication
@RestController
class JWTValidatorController {

    // Demo secret key (DO NOT hardcode in real apps)
    private static final Key SIGNING_KEY =
            Keys.hmacShaKeyFor(
                    "super-secret-signing-key-longer-than-256-bits"
                            .getBytes()
            );


    @GetMapping("/auth/validate")
    public String validate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
            if (authHeader == null) {
                return "No token";
            }
            return "Has token";
    }
}