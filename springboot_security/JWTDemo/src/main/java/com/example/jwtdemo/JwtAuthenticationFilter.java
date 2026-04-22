package com.example.jwtdemo;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Note: This is the class where the actual token Authentication happens, 
// authentication in springboot security is done once per request, it's not done independently for each endpoint

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

                

    }
    
}
