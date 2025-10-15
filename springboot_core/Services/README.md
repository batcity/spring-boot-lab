# Spring Boot Services

In Spring Boot, the `@Service` annotation marks a class as containing **business logic** — the core functionality of the application.

When you annotate a class with `@Service`, Spring automatically detects it during component scanning and registers it as a **Spring bean**.  
This means:
- Spring manages its lifecycle (creation and destruction)
- It can be **injected** into other components (e.g., controllers, other services)
- You don’t need to manually create instances using `new`

Example:

```java
@Service
public class BackgroundService {
    public void runTask() {
        System.out.println("Running background task...");
    }
}

// Then it can be injected into another class:

@SpringBootApplication
public class ServicesApplication implements CommandLineRunner {

    private final BackgroundService backgroundService;

    public ServicesApplication(BackgroundService backgroundService) {
        this.backgroundService = backgroundService;
    }

    @Override
    public void run(String... args) {
        backgroundService.runTask();
    }
}
```

## Why use @Service?

- Keeps business logic separate from controllers and configuration code
- Promotes clean, layered architecture
- Makes your classes easier to test and reuse