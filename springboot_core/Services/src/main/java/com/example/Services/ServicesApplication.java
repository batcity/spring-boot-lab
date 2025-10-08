package com.example.Services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Main Spring Boot application class.
 * Implements CommandLineRunner so we can run code after Spring Boot starts.
 */
@SpringBootApplication
public class ServicesApplication implements CommandLineRunner {

    // Injecting the BackgroundService using Spring's dependency injection
    // This is a major benefit of @Service: Spring manages its lifecycle
    @Autowired
    private BackgroundService backgroundService;

    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class, args);
    }

    /**
     * This method runs after the application starts.
     * All business logic is delegated to the service.
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting the background service...");

        // Call the service to run its task
        // Separation of concerns: main app only orchestrates, service handles logic
        backgroundService.runFor60Seconds();

        // Can call other methods of the service as needed
        System.out.println(backgroundService.getStatus());

        System.out.println("Background service finished!");
    }
}

/**
 * This class contains business logic and is annotated with @Service.
 * Benefits:
 * 1. Spring-managed bean: it can be injected wherever needed.
 * 2. Separation of concerns: logic is separated from application bootstrap.
 * 3. Reusable: can be used in other services or scheduled tasks.
 * 4. Testable: can be tested independently without starting the app.
 */
@Service
class BackgroundService {

    /**
     * Simulates a long-running task for 60 seconds.
     */
    public void runFor60Seconds() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long duration = 60_000; // 60 seconds

        // This loop simulates work being done in the service
        while (System.currentTimeMillis() - startTime < duration) {
            System.out.println("BackgroundService is running...");
            Thread.sleep(5000); // pause 5 seconds between logs to simulate work
        }
    }

    /**
     * An additional reusable method.
     * Demonstrates that services can provide multiple business methods.
     */
    public String getStatus() {
        return "BackgroundService is alive and ready!";
    }
}