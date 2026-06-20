# AI-Powered Incident Management Platform

## Overview

AI-Powered Incident Management Platform is a secure backend application built using Spring Boot that enables organizations to manage incidents, collaborate through comments, and leverage AI-powered analysis for root cause identification and resolution recommendations.

The platform provides JWT-based authentication, role-based access control, incident tracking, comment management, PostgreSQL persistence, Swagger API documentation, and AI integration using Groq LLM.

---

## Live Demo

### API Base URL

https://ai-incident-management-platform-production.up.railway.app

### Swagger Documentation

https://ai-incident-management-platform-production.up.railway.app/swagger-ui/index.html

---

## Features

### Authentication & Authorization

* User Registration
* User Login
* JWT Token Generation
* Secure API Access
* Spring Security Integration

### Incident Management

* Create Incident
* View Incidents
* Update Incident Status
* Track Incident Details
* Store Incident History

### Comment Management

* Add Comments to Incidents
* View Incident Discussions
* Collaborative Incident Tracking

### AI-Powered Analysis

* Root Cause Analysis
* Impact Assessment
* Resolution Recommendations
* Incident Summary Generation
* Groq LLM Integration

### API Documentation

* Swagger UI
* OpenAPI Documentation
* Interactive API Testing

### Cloud Deployment

* Railway Deployment
* PostgreSQL Cloud Database
* Environment Variable Configuration

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* PostgreSQL

### Authentication

* JWT (JSON Web Token)

### AI Integration

* Groq API
* Llama Model

### Documentation

* Swagger OpenAPI

### Build Tool

* Maven

### Deployment

* Railway

### Version Control

* Git
* GitHub

---

## System Architecture

Client
↓
Spring Boot REST API
↓
Spring Security + JWT
↓
Service Layer
↓
Spring Data JPA
↓
PostgreSQL Database

AI Analysis Flow

Incident Description
↓
Groq API
↓
LLM Analysis
↓
Root Cause
Impact
Resolution Steps

---

## Database Design

### Users

| Field    | Type   |
| -------- | ------ |
| id       | Long   |
| name     | String |
| email    | String |
| password | String |
| role     | Enum   |

### Incidents

| Field       | Type      |
| ----------- | --------- |
| id          | Long      |
| title       | String    |
| description | String    |
| status      | Enum      |
| createdAt   | Timestamp |

### Comments

| Field      | Type      |
| ---------- | --------- |
| id         | Long      |
| comment    | String    |
| incidentId | Long      |
| createdAt  | Timestamp |

---

## API Endpoints

### Authentication

#### Register User

POST /api/auth/register

#### Login User

POST /api/auth/login

---

### Incidents

#### Create Incident

POST /api/incidents

#### Get All Incidents

GET /api/incidents

#### Get Incident By Id

GET /api/incidents/{id}

#### Update Incident

PUT /api/incidents/{id}

#### Delete Incident

DELETE /api/incidents/{id}

---

### Comments

#### Add Comment

POST /api/comments

#### Get Comments

GET /api/comments/{incidentId}

---

### AI Analysis

#### Analyze Incident

POST /api/ai/analyze

---

## Security

* JWT Authentication
* Stateless Sessions
* Password Encryption
* Protected APIs
* Spring Security Filters

---

## Environment Variables

Create the following variables:

```properties
SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=

JWT_SECRET=
JWT_EXPIRATION=

GROQ_API_KEY=
```

---

## Local Setup

### Clone Repository

```bash
git clone https://github.com/gkarthik10/ai-incident-management-platform.git
```

### Navigate to Project

```bash
cd ai-incident-management-platform
```

### Configure Environment

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
jwt.expiration=

groq.api.key=
```

### Run Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Future Enhancements

* Role-Based Access Control (Admin/User)
* Email Notifications
* Incident Dashboard
* Analytics & Reporting
* Docker Support
* Kubernetes Deployment
* React Frontend
* Audit Logs
* File Attachments
* Multi-Tenant Support

---

## Learning Outcomes

Through this project, I gained hands-on experience with:

* Spring Boot Development
* REST API Design
* JWT Authentication
* Spring Security
* PostgreSQL Integration
* Hibernate & JPA
* Swagger Documentation
* AI API Integration
* Cloud Deployment
* Production Configuration Management

---

## Author

**Karthik Kumar Reddy Guda**

GitHub:
https://github.com/gkarthik10

LinkedIn:
https://www.linkedin.com/in/gkarthik10/

---

## License

This project is developed for educational and portfolio purposes.
