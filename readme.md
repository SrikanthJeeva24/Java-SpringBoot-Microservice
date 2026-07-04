# 🚀 Spring Boot Microservices Practice

A hands-on Java Spring Boot Microservices project built to learn and demonstrate modern microservices architecture using Spring Boot and Spring Cloud.

This repository is focused on understanding the core building blocks of a production-style microservices application, including service discovery, centralized configuration, API Gateway, JWT authentication, Swagger/OpenAPI, and service-to-service communication.

---

## 📌 Objectives

* Learn Spring Boot Microservices Architecture
* Understand Spring Cloud components
* Build independent microservices
* Implement secure REST APIs using JWT
* Document APIs using Swagger/OpenAPI
* Practice service-to-service communication
* Follow clean project structure and best practices

---

## 🛠️ Tech Stack

| Technology           | Purpose                          |
| -------------------- | -------------------------------- |
| Java 21              | Programming Language             |
| Spring Boot          | Backend Framework                |
| Spring Cloud         | Microservices Ecosystem          |
| Spring Security      | Authentication & Authorization   |
| JWT                  | Stateless Authentication         |
| Spring Data JPA      | Database Access                  |
| MySQL                | Database                         |
| Eureka Server        | Service Discovery                |
| Spring Cloud Config  | Centralized Configuration        |
| Spring Cloud Gateway | API Gateway                      |
| OpenFeign            | Service-to-Service Communication |
| Swagger / OpenAPI    | API Documentation                |
| Maven                | Dependency Management            |
| Git & GitHub         | Version Control                  |

---

# 📁 Project Structure

```text
springboot-microservices-practice
│
├── config-server
├── discovery-server
├── api-gateway
├── user-service
├── job-service
├── config-repo
│
├── README.md
├── .gitignore
└── architecture.png
```

---

# 🏗️ Architecture

```text
                    Client
                       │
                       ▼
                API Gateway
                       │
         ┌─────────────┴─────────────┐
         │                           │
         ▼                           ▼
   User Service                Job Service
         │                           │
         └─────────────┬─────────────┘
                       ▼
                Eureka Server
                       │
                       ▼
                Config Server
                       │
                       ▼
                  Config Repo

         User DB                 Job DB
```

---

# 📦 Microservices

## Config Server

Responsible for centralized configuration management.

### Responsibilities

* Externalized configuration
* Centralized property management
* Environment-specific configuration

---

## Discovery Server (Eureka)

Registers and discovers all microservices.

### Responsibilities

* Service Registration
* Service Discovery
* Load Balancing Support

---

## API Gateway

Acts as a single entry point for all client requests.

### Responsibilities

* Route Requests
* JWT Validation
* Request Forwarding

---

## User Service

Handles user-related operations.

### Features

* User Registration
* Login
* JWT Authentication
* User CRUD APIs

---

## Job Service

Handles job-related operations.

### Features

* Create Job
* Update Job
* Delete Job
* View Jobs

---

# 🔐 Authentication

JWT-based authentication is used.

Workflow:

```text
User Login
      │
      ▼
JWT Token Generated
      │
      ▼
Client Sends Token
      │
      ▼
Gateway/User Service Validates Token
      │
      ▼
Protected APIs
```

---

# 📚 API Documentation

Swagger UI is available for every microservice.

Example:

```
http://localhost:8081/swagger-ui/index.html
```

---

# ▶️ Running the Project

## 1. Clone Repository

```bash
git clone https://github.com/<your-username>/springboot-microservices-practice.git
```

---

## 2. Start Services

Run the services in the following order:

1. Config Server
2. Discovery Server
3. User Service
4. Job Service
5. API Gateway

---

## 3. Verify Eureka

```
http://localhost:8761
```

---

## 4. Access Swagger

```
User Service

http://localhost:8081/swagger-ui/index.html
```

```
Job Service

http://localhost:8082/swagger-ui/index.html
```

---

# ✅ Implemented Features

* Spring Boot Microservices
* Spring Cloud Config Server
* Eureka Service Discovery
* API Gateway
* JWT Authentication
* Spring Security
* Swagger / OpenAPI
* Validation
* Global Exception Handling
* MySQL Integration
* REST APIs

---

# 🚧 Upcoming Features

* OpenFeign Client
* Service-to-Service Communication
* Docker
* Docker Compose
* Resilience4j Circuit Breaker
* Distributed Tracing
* Centralized Logging
* Unit Testing
* Integration Testing
* GitHub Actions (CI/CD)
* Kubernetes (Learning)

---

# 📖 Learning Goals

This project is intended for learning and practicing:

* Spring Boot
* Spring Cloud
* Microservices Architecture
* Secure REST APIs
* Production-style Backend Development
* Clean Code Practices

---

# 🤝 Contributions

Suggestions and improvements are always welcome.

Feel free to fork this repository, raise issues, or submit pull requests.

---

# ⭐ Support

If you found this repository helpful, consider giving it a ⭐ on GitHub.
