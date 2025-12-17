# JWT Gateway Demo

A lightweight Spring Boot system demonstrating JWT-based authentication and validation.

## Components
| Service      | Port | Description                       |
|--------------|------|-----------------------------------|
| auth-service | 8081 | Issues JWT tokens                 |
| sample-api   | 8082 | Protected resource (validates JWT)|

## Flow
1. Client POSTs credentials to `http://localhost:8081/login` → auth-service returns JWT.
2. Client calls `GET http://localhost:8082/api/hello` with header `Authorization: Bearer <token>` → sample-api verifies JWT and responds.


## 🚀 Next Steps
- Add Spring Boot starter code in each module
- Implement token generation (`io.jsonwebtoken`)
