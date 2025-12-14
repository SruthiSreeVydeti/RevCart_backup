# Product Service

## Overview
Handles product catalog, search, categories, and recommendations.

## Port
8082

## Database
MySQL - product_service_db

## Endpoints

### Product Management
- GET /api/products - Get all active products
- GET /api/products/{id} - Get product by ID
- GET /api/products/category/{category} - Get products by category
- GET /api/products/search?keyword={keyword} - Search products
- GET /api/products/categories - Get all categories
- GET /api/products/top-rated - Get top rated products
- POST /api/products - Create product (Admin)
- PUT /api/products/{id} - Update product (Admin)
- DELETE /api/products/{id} - Soft delete product (Admin)

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## Docker

```bash
docker build -t product-service .
docker run -p 8082:8082 product-service
```

## Features
✅ Product CRUD operations
✅ Category management
✅ Search functionality
✅ Top rated products
✅ Soft delete
✅ Consul service discovery
✅ OpenFeign for inter-service calls
✅ Health checks
