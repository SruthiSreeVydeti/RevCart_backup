# Payment Service

## Overview
Handles payment processing with Razorpay integration.

## Port
8085

## Database
MySQL - payment_service_db

## Endpoints

### Payment Management
- POST /api/payments/create - Create Razorpay order
- POST /api/payments/verify - Verify payment signature
- GET /api/payments/user/{userId} - Get user payment history
- GET /api/payments/order/{orderId} - Get payment by order ID

## Configuration

Update `application.properties` with your Razorpay credentials:
```properties
razorpay.key.id=your_key_id
razorpay.key.secret=your_key_secret
```

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## Docker

```bash
docker build -t payment-service .
docker run -p 8085:8085 payment-service
```

## Features
✅ Razorpay integration
✅ Payment order creation
✅ Signature verification
✅ Payment history
✅ Consul service discovery
✅ OpenFeign for inter-service calls
✅ Health checks
