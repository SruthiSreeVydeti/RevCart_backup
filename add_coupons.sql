USE order_service_db;

INSERT INTO coupons (code, description, discount_type, discount_value, min_order_amount, max_discount_amount, valid_from, valid_until, active, usage_limit, used_count) VALUES
('WELCOME10', '10% off on first order', 'PERCENTAGE', 10.0, 500.0, 100.0, '2024-01-01 00:00:00', '2025-12-31 23:59:59', true, 1000, 0),
('SAVE20', '20% off on orders above ₹1000', 'PERCENTAGE', 20.0, 1000.0, 200.0, '2024-01-01 00:00:00', '2025-12-31 23:59:59', true, 500, 0),
('FLAT50', 'Flat ₹50 off on orders above ₹300', 'FIXED', 50.0, 300.0, 50.0, '2024-01-01 00:00:00', '2025-12-31 23:59:59', true, 1000, 0),
('MEGA30', '30% off on orders above ₹2000', 'PERCENTAGE', 30.0, 2000.0, 500.0, '2024-01-01 00:00:00', '2025-12-31 23:59:59', true, 200, 0),
('FLAT100', 'Flat ₹100 off on orders above ₹800', 'FIXED', 100.0, 800.0, 100.0, '2024-01-01 00:00:00', '2025-12-31 23:59:59', true, 300, 0),
('SUPER15', '15% off on orders above ₹1500', 'PERCENTAGE', 15.0, 1500.0, 300.0, '2024-01-01 00:00:00', '2025-12-31 23:59:59', true, 400, 0);