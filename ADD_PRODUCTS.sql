USE revcart_db;

INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES
('Fresh Apples', 'Organic red apples', 120.00, 'Fruits', 'https://via.placeholder.com/200', 100, true),
('Bananas', 'Fresh yellow bananas', 50.00, 'Fruits', 'https://via.placeholder.com/200', 150, true),
('Tomatoes', 'Fresh red tomatoes', 40.00, 'Vegetables', 'https://via.placeholder.com/200', 80, true),
('Potatoes', 'Farm fresh potatoes', 30.00, 'Vegetables', 'https://via.placeholder.com/200', 200, true),
('Milk', 'Fresh dairy milk 1L', 60.00, 'Dairy', 'https://via.placeholder.com/200', 50, true),
('Bread', 'Whole wheat bread', 40.00, 'Bakery', 'https://via.placeholder.com/200', 30, true),
('Rice', 'Basmati rice 1kg', 80.00, 'Grains', 'https://via.placeholder.com/200', 100, true),
('Chicken', 'Fresh chicken 1kg', 200.00, 'Meat', 'https://via.placeholder.com/200', 40, true);

INSERT INTO coupons (code, description, discount_type, discount_value, min_order_amount, max_discount_amount, valid_from, valid_until, usage_limit, used_count, active) VALUES
('WELCOME10', 'Welcome discount 10%', 'PERCENTAGE', 10.00, 100.00, 50.00, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 100, 0, true),
('SAVE50', 'Flat 50 off', 'FIXED', 50.00, 200.00, 50.00, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 50, 0, true);
