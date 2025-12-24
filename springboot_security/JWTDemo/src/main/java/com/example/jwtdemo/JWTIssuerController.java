package com.example.jwtdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
class JWTIssuerController {

    public static void main(String args[]) {
        SpringApplication.run(JWTIssuerController.class, args);
    }

    // 🔐 Demo secret key (DO NOT hardcode in real apps)
    private static final Key SIGNING_KEY =
            Keys.hmacShaKeyFor(
                    "super-secret-signing-key-longer-than-256-bits"
                            .getBytes()
            );


    @GetMapping("/login")
    public String login() {

        Instant now = Instant.now();

        String jwt = Jwts.builder()
                .setSubject("demo-user")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(3600))) // 1 hour
                .claim("role", "USER")
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }
}