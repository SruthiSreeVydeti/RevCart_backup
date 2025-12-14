# Order Service

## Overview
Handles order creation, tracking, and management.

## Port
8084

## Database
MySQL - order_service_db

## Endpoints

### Order Management
- POST /api/orders - Create new order
- GET /api/orders/user/{userId} - Get user orders
- GET /api/orders/{id} - Get order by ID
- GET /api/orders/number/{orderNumber} - Get order by number
- PUT /api/orders/{id}/status?status={status} - Update order status
- GET /api/orders/status/{status} - Get orders by status

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## Docker

```bash
docker build -t order-service .
docker run -p 8084:8084 order-service
```

## Features
✅ Order creation with items
✅ Order tracking by ID/number
✅ User order history
✅ Status management
✅ Transaction support
✅ Consul service discovery
✅ OpenFeign for inter-service calls
✅ Health checks
