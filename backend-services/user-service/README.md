# User Service

## Overview
Handles user authentication, profile management, and address management.

## Port
8081

## Database
MySQL - user_service_db

## Endpoints

### Authentication
- POST /api/auth/signup - Register new user
- POST /api/auth/signin - Login user
- GET /api/auth/validate - Validate JWT token

### User Management
- GET /api/users/{id} - Get user by ID
- PUT /api/users/{id} - Update user profile
- GET /api/users/{userId}/addresses - Get user addresses
- POST /api/users/addresses - Add new address
- DELETE /api/users/addresses/{id} - Delete address

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## Docker

```bash
docker build -t user-service .
docker run -p 8081:8081 user-service
```

## Features
✅ JWT Authentication
✅ Password encryption (BCrypt)
✅ User registration & login
✅ Profile management
✅ Address management
✅ Consul service discovery
✅ Health checks
