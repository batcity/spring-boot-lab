# JWT Gateway Demo

A lightweight Spring Boot system demonstrating JWT-based authentication and validation via an API Gateway.

## 🧱 Components
| Service | Port | Description |
|----------|------|-------------|
| `auth-service` | 8081 | Issues JWT tokens |
| `api-gateway` | 8080 | Validates JWTs and routes requests |
| `sample-api` | 8082 | Exposes a protected resource |

## 🧭 Flow
1. `POST /login` → Auth Service issues JWT
2. Client stores token
3. `GET /api/hello` → API Gateway verifies JWT, forwards to Sample API

## 🚀 Next Steps
- Add Spring Boot starter code in each module
- Implement token generation (`io.jsonwebtoken`)
- Configure API Gateway for route validation
