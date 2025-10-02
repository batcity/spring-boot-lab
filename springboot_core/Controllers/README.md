# Controllers in Spring Boot

In Spring Boot, a **controller** is a central part of the web layer. It handles incoming HTTP requests, processes them (often by calling services), and returns a response.

Controllers come from the Spring MVC framework and are made easier to use with Spring Boot’s auto-configuration.


## What is a Controller?

A controller is a **Java class** that contains **handler methods**.  
Each handler method is mapped to a specific URL or HTTP request type (GET, POST, PUT, DELETE, etc.) using annotations like:

- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`


## Types of Controllers in Spring Boot

Spring Boot provides two main types:

1. **`@Controller`**  
   - Used for **web applications that return views** (e.g., Thymeleaf, JSP).  
   - Typically returns an **HTML page** as a response.  

2. **`@RestController`**  
   - A shorthand for `@Controller + @ResponseBody`.  
   - Used for **REST APIs**.  
   - Returns data (usually **JSON** or XML) directly in the HTTP response.


## Example: REST Controller

Here’s a minimal example of a REST controller:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id) {
        return "Fetching user with ID: " + id;
    }
}
````

### Try it out

Start the application in the example and call the endpoints:

```bash
curl http://localhost:8080/hello
# → "Hello from Spring Boot!"

curl http://localhost:8080/users/42
# → "Fetching user with ID: 42"
```


## Controllers in a Typical Spring Boot Application

In real-world apps, controllers are only one layer of the architecture:

* **Controller** → Handles HTTP requests
* **Service** → Contains business logic
* **Repository** → Manages data persistence

This separation keeps the code clean and maintainable.


## Frequently asked Questions:

### Modern Layered Architecture vs Classic MVC

**Modern REST-layered architecture (new standard):**

```
Controller → Service → Repository → Model
```

* Controller: handles HTTP requests
* Service: business logic
* Repository: database access
* Model: data objects (entities/DTOs)

### 🚀 Why Controller → Service → Repository → Model is the new standard

- **Clear separation of concerns**  
  Each layer has a single responsibility: controllers handle HTTP, services handle business logic, repositories handle database access, models hold data.

- **Easier testing & maintenance**  
  Layers can be tested independently; changes in one layer rarely break others.

- **API-first approach for multi-device support**  
  Backends serve JSON or GraphQL APIs, allowing web, mobile, and IoT clients to interact with the same data.

- **Frontend-backend independence**  
  Frontend developers (React, Angular, Vue, etc.) and backend developers can work separately. Backend focuses on data, frontend on rendering and user experience.

- **Cloud-native and microservice-friendly**  
  APIs are modular and reusable in containerized, microservice-heavy architectures, unlike server-rendered MVC pages.



**What is Classic MVC (less common today):**

```
Controller → Model → View
```

* Model handled data + business logic + DB queries
* View rendered server-side HTML (Thymeleaf, JSP)
* Declined because frontends now handle rendering, backends mostly serve JSON

### Differences at a Glance

| Aspect          | Classic MVC                 | Modern REST Layering                  |
| --------------- | --------------------------- | ------------------------------------- |
| Controller role | Maps HTTP → View/Model      | Maps HTTP → Service/Repository/Model  |
| Model           | Data + logic + DB queries   | Just data (entities/DTOs)             |
| View            | Server-rendered HTML        | Handled by frontend (React/SPA)       |
| Usage           | Legacy apps, small internal | Most new projects, APIs/microservices |

**Takeaway:**

* Classic MVC isn’t dead, but low usage in new projects.
* Modern layered architecture dominates API-first Spring Boot development.
* Understanding both helps you know when to use server-side rendering vs REST APIs.


## Summary

* Use **`@Controller`** for web apps that return views.
* Use **`@RestController`** for APIs that return JSON or XML.
* Map request URLs to handler methods using annotations like `@GetMapping`.
* Keep controllers thin — delegate business logic to services and data access to repositories.
* Modern Spring Boot favors **Controller → Service → Repository → Model** for API-first design.
* Classic MVC is mostly for server-rendered HTML apps and legacy projects.
