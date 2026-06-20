# AI-Powered Incident Management Platform

## Overview

AI-Powered Incident Management Platform is a production-style backend application built using Spring Boot. The platform enables organizations to manage incidents, collaborate through comments, enforce role-based access control, and leverage AI-powered root cause analysis for faster incident resolution.

The application follows a layered architecture and demonstrates industry-standard backend development practices including authentication, authorization, validation, exception handling, database relationships, API documentation, and external AI integration.

---

## Key Features

### Authentication & Authorization

* User Registration and Login
* JWT-Based Authentication
* BCrypt Password Encryption
* Role-Based Access Control (RBAC)
* Roles: ADMIN, ENGINEER, EMPLOYEE

### Incident Management

* Create Incidents
* Retrieve Incidents
* Update Incident Status
* Delete Incidents
* Severity Classification
* Status Tracking

### Comment Management

* Add Comments to Incidents
* Retrieve Incident Comments
* Collaborative Incident Investigation

### AI-Powered Root Cause Analysis

* Integrates with Groq LLM API
* Generates Possible Root Causes
* Identifies Business Impact
* Suggests Resolution Steps

### API Documentation

* Swagger/OpenAPI Integration
* Interactive API Testing

### Production Features

* DTO Pattern
* Global Exception Handling
* Input Validation
* Layered Architecture
* Database Relationships

---

## Technology Stack

### Backend

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Security

* JWT Authentication
* BCrypt Password Encoding
* Role-Based Access Control

### AI Integration

* Groq API
* Llama 3.1 Model

### Documentation & Testing

* Swagger/OpenAPI
* Postman

### Build & Version Control

* Maven
* Git
* GitHub

---

## System Architecture

Client (Postman / Swagger)

↓

Controller Layer

↓

Service Layer

↓

Repository Layer

↓

MySQL Database

↓

External AI Service (Groq)

---

## Database Design

### User

| Field    | Type   |
| -------- | ------ |
| id       | Long   |
| name     | String |
| email    | String |
| password | String |
| role     | Enum   |

### Incident

| Field       | Type          |
| ----------- | ------------- |
| id          | Long          |
| title       | String        |
| description | String        |
| severity    | Enum          |
| status      | Enum          |
| createdAt   | LocalDateTime |
| updatedAt   | LocalDateTime |

### Comment

| Field     | Type          |
| --------- | ------------- |
| id        | Long          |
| message   | String        |
| createdAt | LocalDateTime |
| incident  | Incident      |

### Entity Relationships

* One Incident → Many Comments
* Many Comments → One Incident

---

## API Endpoints

### Authentication

| Method | Endpoint           |
| ------ | ------------------ |
| POST   | /api/auth/register |
| POST   | /api/auth/login    |

### Incident Management

| Method | Endpoint                   |
| ------ | -------------------------- |
| POST   | /api/incidents             |
| GET    | /api/incidents             |
| GET    | /api/incidents/{id}        |
| PUT    | /api/incidents/{id}/status |
| DELETE | /api/incidents/{id}        |

### Comment Management

| Method | Endpoint                     |
| ------ | ---------------------------- |
| POST   | /api/incidents/{id}/comments |
| GET    | /api/incidents/{id}/comments |

### AI Analysis

| Method | Endpoint        |
| ------ | --------------- |
| POST   | /api/ai/analyze |

---

## Security Implementation

### Authentication

* JWT Token Generation
* JWT Validation
* Stateless Authentication

### Authorization

| Role     | Permissions                 |
| -------- | --------------------------- |
| ADMIN    | Full Access                 |
| ENGINEER | Manage Incidents & Comments |
| EMPLOYEE | Create and View Incidents   |

---

## Sample AI Analysis

### Input

Database connection timeout while processing payments

### Output

* Possible Root Causes
* Impact Assessment
* Suggested Resolution Steps
* Troubleshooting Recommendations

---

## Project Structure

src/main/java

├── controller

├── service

├── repository

├── entity

├── dto

├── security

├── config

└── exception

---

## Local Setup

### Clone Repository

```bash
git clone <repository-url>
```

### Configure Application Properties

Create:

```properties
application.properties
```

Add:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=

groq.api.key=
```

### Run Application

```bash
mvn spring-boot:run
```

### Access Swagger

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Future Enhancements

* React Frontend
* Email Notifications
* Incident Assignment Workflow
* Dashboard Analytics
* Audit Logging
* File Attachments
* Docker Containerization
* Cloud Deployment
* CI/CD Pipeline

---

## Learning Outcomes

This project demonstrates practical experience with:

* Spring Boot
* REST API Development
* JWT Authentication
* Role-Based Access Control
* JPA/Hibernate
* MySQL
* DTO Pattern
* Exception Handling
* API Documentation
* AI Integration
* Production-Style Backend Architecture

---

## Author

**Karthik Kumar Reddy Guda**

