# Available Coupons

## 6 Active Coupons Added to Your System

### 1. WELCOME10
- **Description**: 10% off on first order
- **Type**: Percentage discount
- **Discount**: 10%
- **Minimum Order**: ₹500
- **Maximum Discount**: ₹100
- **Usage Limit**: 1000 times

### 2. SAVE20
- **Description**: 20% off on orders above ₹1000
- **Type**: Percentage discount
- **Discount**: 20%
- **Minimum Order**: ₹1000
- **Maximum Discount**: ₹200
- **Usage Limit**: 500 times

### 3. FLAT50
- **Description**: Flat ₹50 off on orders above ₹300
- **Type**: Fixed amount discount
- **Discount**: ₹50
- **Minimum Order**: ₹300
- **Usage Limit**: 1000 times

### 4. MEGA30
- **Description**: 30% off on orders above ₹2000
- **Type**: Percentage discount
- **Discount**: 30%
- **Minimum Order**: ₹2000
- **Maximum Discount**: ₹500
- **Usage Limit**: 200 times

### 5. FLAT100
- **Description**: Flat ₹100 off on orders above ₹800
- **Type**: Fixed amount discount
- **Discount**: ₹100
- **Minimum Order**: ₹800
- **Usage Limit**: 300 times

### 6. SUPER15
- **Description**: 15% off on orders above ₹1500
- **Type**: Percentage discount
- **Discount**: 15%
- **Minimum Order**: ₹1500
- **Maximum Discount**: ₹300
- **Usage Limit**: 400 times

## API Endpoints

- **GET /api/coupons** - Get all active coupons
- **POST /api/coupons/validate** - Validate coupon and calculate discount
- **POST /api/coupons/apply** - Apply coupon (increments usage count)

## Test Results ✅

All coupons are working correctly:
- ✅ Percentage discounts calculated properly
- ✅ Fixed amount discounts applied correctly
- ✅ Minimum order amount validation working
- ✅ Maximum discount limits enforced
- ✅ Usage count tracking functional
- ✅ Invalid coupon scenarios handled properly