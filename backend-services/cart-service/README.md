# Cart Service

## Overview
Handles shopping cart management with Redis caching.

## Port
8083

## Database
MySQL + Redis

## Endpoints

### Cart Management
- GET /api/cart/{userId} - Get user cart
- POST /api/cart/{userId}/add - Add item to cart
- DELETE /api/cart/{userId}/remove/{productId} - Remove item
- DELETE /api/cart/{userId}/clear - Clear cart

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## Docker

```bash
docker build -t cart-service .
docker run -p 8083:8083 cart-service
```

## Features
✅ Cart CRUD operations
✅ Redis session management
✅ Automatic cart creation
✅ Item quantity management
✅ Consul service discovery
✅ OpenFeign for inter-service calls
✅ Health checks
