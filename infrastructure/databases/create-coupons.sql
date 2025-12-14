-- Create coupons table
CREATE TABLE IF NOT EXISTS coupons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    discount_type VARCHAR(20) NOT NULL,
    discount_value DECIMAL(10,2) NOT NULL,
    min_order_amount DECIMAL(10,2),
    max_discount_amount DECIMAL(10,2),
    valid_from DATETIME NOT NULL,
    valid_until DATETIME NOT NULL,
    usage_limit INT,
    used_count INT DEFAULT 0,
    active BOOLEAN DEFAULT true,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert sample coupons
INSERT INTO coupons (code, description, discount_type, discount_value, min_order_amount, max_discount_amount, valid_from, valid_until, usage_limit, active) VALUES
('WELCOME50', 'Welcome offer - Flat ₹50 off on first order', 'FLAT', 50.00, 299.00, 50.00, '2024-01-01', '2025-12-31', 1000, true),
('SAVE100', 'Save ₹100 on orders above ₹999', 'FLAT', 100.00, 999.00, 100.00, '2024-01-01', '2025-12-31', 5000, true),
('MEGA20', 'Get 20% off on orders above ₹1499', 'PERCENTAGE', 20.00, 1499.00, 500.00, '2024-01-01', '2025-12-31', 3000, true),
('FRESH15', 'Fresh deals - 15% off on fruits & vegetables', 'PERCENTAGE', 15.00, 499.00, 200.00, '2024-01-01', '2025-12-31', 2000, true),
('GROCERY200', 'Flat ₹200 off on grocery shopping above ₹1999', 'FLAT', 200.00, 1999.00, 200.00, '2024-01-01', '2025-12-31', 1500, true),
('FASHION25', 'Fashion sale - 25% off on clothing', 'PERCENTAGE', 25.00, 999.00, 1000.00, '2024-01-01', '2025-12-31', 2500, true),
('ELECTRONICS10', '10% off on electronics', 'PERCENTAGE', 10.00, 2999.00, 2000.00, '2024-01-01', '2025-12-31', 1000, true),
('FIRSTBUY', 'First time buyer special - ₹75 off', 'FLAT', 75.00, 499.00, 75.00, '2024-01-01', '2025-12-31', 5000, true),
('SUPERSAVER', 'Super saver - 30% off on orders above ₹2499', 'PERCENTAGE', 30.00, 2499.00, 1000.00, '2024-01-01', '2025-12-31', 500, true),
('WEEKEND50', 'Weekend special - ₹50 off on all orders', 'FLAT', 50.00, 399.00, 50.00, '2024-01-01', '2025-12-31', 10000, true);
