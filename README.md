# RevCart Microservices - Distributed E-Commerce Architecture

## Architecture Overview

Complete microservices implementation with independent deployment, scaling, and database per service.

## Microservices

| Service | Port | Database | Responsibility |
|---------|------|----------|----------------|
| **Config Server** | 8888 | - | Centralized configuration |
| **API Gateway** | 8080 | - | Single entry point, routing, load balancing |
| **User Service** | 8081 | MySQL | Authentication, profile, address management |
| **Product Service** | 8082 | MySQL | Product catalog, pricing, categories |
| **Cart Service** | 8083 | Redis | Cart management, session persistence |
| **Order Service** | 8084 | MySQL | Order placement, status, history |
| **Payment Service** | 8085 | MySQL | Payment processing, Razorpay integration |
| **Notification Service** | 8087 | MongoDB | Email, WebSocket notifications |
| **Delivery Service** | 8086 | MySQL | Delivery tracking, agent management |
| **Analytics Service** | 8088 | MongoDB | Sales trends, customer insights |

## Technology Stack

- **Framework**: Spring Boot 3.3.5
- **Java**: 17
- **Service Discovery**: Consul
- **API Gateway**: Spring Cloud Gateway
- **Circuit Breaker**: Resilience4j
- **Inter-service Communication**: OpenFeign
- **Databases**: MySQL, MongoDB, Redis
- **Messaging**: Kafka (for Delivery Service)
- **Containerization**: Docker
- **Orchestration**: Kubernetes ready

## Quick Start

### 1. Start Infrastructure
```bash
cd infrastructure\consul
docker-compose up -d
```

### 2. Build All Services
```bash
mvn clean install -DskipTests
```

### 3. Start Services
```bash
docker-compose up -d --build
```

### 4. Access Points
- **API Gateway**: http://localhost:8080
- **Consul UI**: http://localhost:8500
- **Config Server**: http://localhost:8888

## API Routes (via Gateway)

### User Service
- POST /api/auth/signup
- POST /api/auth/signin
- GET /api/users/profile
- PUT /api/users/address

### Product Service
- GET /api/products
- GET /api/products/{id}
- POST /api/products (Admin)
- GET /api/products/search

### Cart Service
- GET /api/cart
- POST /api/cart/add
- DELETE /api/cart/remove

### Order Service
- POST /api/orders
- GET /api/orders
- GET /api/orders/{id}

### Payment Service
- POST /api/payments/create
- POST /api/payments/verify
- GET /api/payments/history

### Notification Service
- GET /api/notifications
- WebSocket: ws://localhost:8087/ws

### Delivery Service
- GET /api/delivery/track/{orderId}
- POST /api/delivery/assign
- GET /api/delivery/agents

### Analytics Service
- GET /api/analytics/sales
- GET /api/analytics/customers
- GET /api/analytics/trends

## Database Setup

Each service has its own database for data isolation:

```sql
CREATE DATABASE user_service_db;
CREATE DATABASE product_service_db;
CREATE DATABASE order_service_db;
CREATE DATABASE payment_service_db;
CREATE DATABASE delivery_service_db;
```

MongoDB databases:
- notification_service_db
- analytics_service_db

## Features Implemented

✅ Service Discovery with Consul
✅ API Gateway with routing and load balancing
✅ Circuit Breaker pattern with Resilience4j
✅ Database per service
✅ Independent deployment
✅ Docker containerization
✅ Health checks and monitoring
✅ Centralized configuration
✅ Inter-service communication with OpenFeign
✅ Redis for cart session management
✅ Kafka for delivery events
✅ WebSocket for real-time notifications

## Scaling Strategy

- **Product Service**: Scale during high traffic
- **Order Service**: Scale during checkout peaks
- **Payment Service**: Independent scaling for payment processing
- **Cart Service**: Redis-backed for session management
- **Delivery Service**: Kafka-based event processing

## Development

Each microservice can be developed, tested, and deployed independently:

```bash
cd backend-services/user-service
mvn spring-boot:run
```

## CI/CD Ready

Each service has its own:
- Dockerfile
- Jenkinsfile
- Kubernetes deployment manifests
