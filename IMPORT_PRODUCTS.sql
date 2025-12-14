USE revcart_db;

-- Clear existing
DELETE FROM products;

-- FRUITS (12 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Fresh Apples', 'Fresh red apples', 120.00, 'fruits', 'https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6?w=300&h=200&fit=crop', 100, true),
('Bananas', 'Ripe yellow bananas', 60.00, 'fruits', 'https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?w=300&h=200&fit=crop', 150, true),
('Oranges', 'Juicy oranges', 100.00, 'fruits', 'https://images.unsplash.com/photo-1547514701-42782101795e?w=300&h=200&fit=crop', 120, true),
('Grapes', 'Sweet grapes', 150.00, 'fruits', 'https://images.unsplash.com/photo-1585518419759-87a89d9b2d4f?w=300&h=200&fit=crop', 80, true),
('Strawberries', 'Fresh strawberries', 200.00, 'fruits', 'https://images.unsplash.com/photo-1464454709131-ffd692591ee5?w=300&h=200&fit=crop', 60, true),
('Mangoes', 'Sweet mangoes', 180.00, 'fruits', 'https://images.unsplash.com/photo-1553279768-865429fa0078?w=300&h=200&fit=crop', 90, true),
('Pineapple', 'Fresh pineapple', 80.00, 'fruits', 'https://images.unsplash.com/photo-1550258987-190a2d41a8ba?w=300&h=200&fit=crop', 70, true),
('Watermelon', 'Juicy watermelon', 40.00, 'fruits', 'https://images.unsplash.com/photo-1587049352846-4a222e784422?w=300&h=200&fit=crop', 100, true),
('Papaya', 'Fresh papaya', 70.00, 'fruits', 'https://images.unsplash.com/photo-1617112848923-cc2234396a8d?w=300&h=200&fit=crop', 85, true),
('Guava', 'Sweet guava', 50.00, 'fruits', 'https://images.unsplash.com/photo-1536511132770-e5058c7e8c46?w=300&h=200&fit=crop', 95, true),
('Kiwi', 'Fresh kiwi', 160.00, 'fruits', 'https://images.unsplash.com/photo-1585059895524-72359e06133a?w=300&h=200&fit=crop', 50, true),
('Pomegranate', 'Fresh pomegranate', 120.00, 'fruits', 'https://images.unsplash.com/photo-1615485290382-441e4d049cb5?w=300&h=200&fit=crop', 75, true);

-- VEGETABLES (12 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Carrots', 'Fresh orange carrots', 40.00, 'vegetables', 'https://images.unsplash.com/photo-1445282768818-728615cc910a?w=300&h=200&fit=crop', 150, true),
('Tomatoes', 'Fresh red tomatoes', 80.00, 'vegetables', 'https://images.unsplash.com/photo-1592924357228-91a4daadcfea?w=300&h=200&fit=crop', 200, true),
('Onions', 'Fresh onions', 30.00, 'vegetables', 'https://images.unsplash.com/photo-1508747703725-719777637510?w=300&h=200&fit=crop', 180, true),
('Potatoes', 'Fresh potatoes', 25.00, 'vegetables', 'https://images.unsplash.com/photo-1518977676601-b53f82aba655?w=300&h=200&fit=crop', 250, true),
('Broccoli', 'Fresh broccoli', 60.00, 'vegetables', 'https://images.unsplash.com/photo-1459411621453-7b03977f4bfc?w=300&h=200&fit=crop', 90, true),
('Spinach', 'Fresh spinach leaves', 35.00, 'vegetables', 'https://images.unsplash.com/photo-1511689915661-c6dcc9b12e6d?w=300&h=200&fit=crop', 100, true),
('Bell Peppers', 'Colorful bell peppers', 70.00, 'vegetables', 'https://images.unsplash.com/photo-1563565375-f3fdfdbefa83?w=300&h=200&fit=crop', 110, true),
('Cauliflower', 'Fresh cauliflower', 45.00, 'vegetables', 'https://images.unsplash.com/photo-1568584711271-61a0f6a6e0e8?w=300&h=200&fit=crop', 95, true),
('Cucumber', 'Fresh cucumber', 35.00, 'vegetables', 'https://images.unsplash.com/photo-1604977042946-1eecc30f269e?w=300&h=200&fit=crop', 130, true),
('Cabbage', 'Fresh cabbage', 30.00, 'vegetables', 'https://images.unsplash.com/photo-1594282486552-05b4d80fbb9f?w=300&h=200&fit=crop', 140, true),
('Garlic', 'Fresh garlic', 50.00, 'vegetables', 'https://images.unsplash.com/photo-1588184344470-7e4d5b8e9c3f?w=300&h=200&fit=crop', 120, true),
('Ginger', 'Fresh ginger', 60.00, 'vegetables', 'https://images.unsplash.com/photo-1599599810694-b5ac4dd64b73?w=300&h=200&fit=crop', 100, true);

-- DAIRY (10 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Milk', 'Fresh cow milk', 55.00, 'dairy', 'https://images.unsplash.com/photo-1550583724-b2692b25a968?w=300&h=200&fit=crop', 200, true),
('Cheese', 'Fresh cheese', 200.00, 'dairy', 'https://images.unsplash.com/photo-1486297678162-eb2a19b0a32d?w=300&h=200&fit=crop', 80, true),
('Yogurt', 'Greek yogurt', 45.00, 'dairy', 'https://images.unsplash.com/photo-1488477181946-6428a0291840?w=300&h=200&fit=crop', 150, true),
('Butter', 'Fresh butter', 120.00, 'dairy', 'https://images.unsplash.com/photo-1589985643862-8633ae57811f?w=300&h=200&fit=crop', 100, true),
('Cream', 'Heavy cream', 80.00, 'dairy', 'https://images.unsplash.com/photo-1628088062854-d1870b4553da?w=300&h=200&fit=crop', 90, true),
('Ice Cream', 'Vanilla ice cream', 150.00, 'dairy', 'https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=300&h=200&fit=crop', 120, true),
('Paneer', 'Fresh paneer', 180.00, 'dairy', 'https://images.unsplash.com/photo-1631452180519-c014fe946bc7?w=300&h=200&fit=crop', 70, true),
('Ghee', 'Pure cow ghee', 300.00, 'dairy', 'https://images.unsplash.com/photo-1599599810694-b5ac4dd64b73?w=300&h=200&fit=crop', 60, true),
('Curd', 'Fresh curd', 40.00, 'dairy', 'https://images.unsplash.com/photo-1571212515416-fca2ce42c3f8?w=300&h=200&fit=crop', 140, true),
('Mozzarella', 'Fresh mozzarella', 250.00, 'dairy', 'https://images.unsplash.com/photo-1618164436241-4473940d1f5c?w=300&h=200&fit=crop', 50, true);

-- BAKERY (10 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Bread', 'Whole wheat bread', 35.00, 'bakery', 'https://images.unsplash.com/photo-1509042239860-f550ce710b93?w=300&h=200&fit=crop', 100, true),
('Croissant', 'Buttery croissant', 25.00, 'bakery', 'https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=300&h=200&fit=crop', 80, true),
('Muffins', 'Blueberry muffins', 80.00, 'bakery', 'https://images.unsplash.com/photo-1607958996333-41aef7caefaa?w=300&h=200&fit=crop', 60, true),
('Cookies', 'Chocolate cookies', 60.00, 'bakery', 'https://images.unsplash.com/photo-1499636136210-6f4ee915583e?w=300&h=200&fit=crop', 90, true),
('Donuts', 'Glazed donuts', 120.00, 'bakery', 'https://images.unsplash.com/photo-1551024506-0bccd828d307?w=300&h=200&fit=crop', 70, true),
('Cake', 'Chocolate cake', 400.00, 'bakery', 'https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=300&h=200&fit=crop', 40, true),
('Bagels', 'Fresh bagels', 90.00, 'bakery', 'https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=300&h=200&fit=crop', 75, true),
('Pastry', 'Fruit pastry', 50.00, 'bakery', 'https://images.unsplash.com/photo-1509440159596-0249088772ff?w=300&h=200&fit=crop', 85, true),
('Brownies', 'Fudgy brownies', 100.00, 'bakery', 'https://images.unsplash.com/photo-1607920591413-4ec007e70023?w=300&h=200&fit=crop', 65, true),
('Cheesecake', 'New York cheesecake', 350.00, 'bakery', 'https://images.unsplash.com/photo-1533134242820-b4f3b4e0c2b7?w=300&h=200&fit=crop', 45, true);

-- ELECTRONICS (10 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Smartphone', 'Latest smartphone', 15000.00, 'electronics', 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=300&h=200&fit=crop', 50, true),
('Headphones', 'Wireless headphones', 2500.00, 'electronics', 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=300&h=200&fit=crop', 80, true),
('Laptop', 'Gaming laptop', 45000.00, 'electronics', 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=300&h=200&fit=crop', 30, true),
('Smart Watch', 'Fitness smart watch', 8000.00, 'electronics', 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=300&h=200&fit=crop', 60, true),
('Tablet', '10-inch tablet', 20000.00, 'electronics', 'https://images.unsplash.com/photo-1561070791-2526d30994b5?w=300&h=200&fit=crop', 40, true),
('Power Bank', '10000mAh power bank', 1500.00, 'electronics', 'https://images.unsplash.com/photo-1609091839311-d5365f9ff1c5?w=300&h=200&fit=crop', 100, true),
('Bluetooth Speaker', 'Portable speaker', 3000.00, 'electronics', 'https://images.unsplash.com/photo-1589003077984-894e133814c9?w=300&h=200&fit=crop', 70, true),
('Wireless Mouse', 'Ergonomic wireless mouse', 800.00, 'electronics', 'https://images.unsplash.com/photo-1527814050087-3793815479db?w=300&h=200&fit=crop', 90, true),
('USB Cable', 'High-speed USB cable', 200.00, 'electronics', 'https://images.unsplash.com/photo-1625948515291-69613efd103f?w=300&h=200&fit=crop', 150, true),
('Phone Case', 'Protective phone case', 400.00, 'electronics', 'https://images.unsplash.com/photo-1601784551446-20c9e07cdbdb?w=300&h=200&fit=crop', 120, true);

-- SPORTS (10 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Football', 'Professional football', 800.00, 'sports', 'https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=300&h=200&fit=crop', 60, true),
('Cricket Bat', 'Professional cricket bat', 1200.00, 'sports', 'https://images.unsplash.com/photo-1624526267942-ab67cb7db225?w=300&h=200&fit=crop', 40, true),
('Cricket Ball', 'Leather cricket ball', 300.00, 'sports', 'https://images.unsplash.com/photo-1531415074968-7e9a4f2f6e3e?w=300&h=200&fit=crop', 80, true),
('Tennis Racket', 'Professional tennis racket', 1500.00, 'sports', 'https://images.unsplash.com/photo-1554224311-beee415c15c8?w=300&h=200&fit=crop', 50, true),
('Basketball', 'Professional basketball', 900.00, 'sports', 'https://images.unsplash.com/photo-1546519638-68711109d298?w=300&h=200&fit=crop', 55, true),
('Badminton Racket', 'Lightweight badminton racket', 800.00, 'sports', 'https://images.unsplash.com/photo-1626224583764-f87db24ac4ea?w=300&h=200&fit=crop', 70, true),
('Volleyball', 'Professional volleyball', 600.00, 'sports', 'https://images.unsplash.com/photo-1612872087720-bb876e2e67d1?w=300&h=200&fit=crop', 65, true),
('Yoga Mat', 'Premium yoga mat', 600.00, 'sports', 'https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=300&h=200&fit=crop', 90, true),
('Dumbbells', 'Adjustable dumbbells', 2000.00, 'sports', 'https://images.unsplash.com/photo-1534438327276-14e5300c3a48?w=300&h=200&fit=crop', 45, true),
('Swimming Goggles', 'Anti-fog swimming goggles', 350.00, 'sports', 'https://images.unsplash.com/photo-1519315901367-f34ff9154487?w=300&h=200&fit=crop', 100, true);

-- KIDS (8 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Teddy Bear', 'Soft teddy bear', 500.00, 'kids', 'https://images.unsplash.com/photo-1585951237318-9ea5e175b891?w=300&h=200&fit=crop', 80, true),
('Building Blocks', 'Colorful building blocks', 800.00, 'kids', 'https://images.unsplash.com/photo-1594787318286-3d835c1cab83?w=300&h=200&fit=crop', 60, true),
('Puzzle Game', 'Educational puzzle', 300.00, 'kids', 'https://images.unsplash.com/photo-1587654780291-39c9404d746b?w=300&h=200&fit=crop', 90, true),
('Remote Car', 'RC racing car', 1200.00, 'kids', 'https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=300&h=200&fit=crop', 50, true),
('Action Figure', 'Superhero action figure', 400.00, 'kids', 'https://images.unsplash.com/photo-1531525645387-7f14be1bdbbd?w=300&h=200&fit=crop', 70, true),
('Board Game', 'Family board game', 600.00, 'kids', 'https://images.unsplash.com/photo-1610890716171-6b1bb98ffd09?w=300&h=200&fit=crop', 65, true),
('Coloring Book', 'Creative coloring book', 150.00, 'kids', 'https://images.unsplash.com/photo-1513542789411-b6a5d4f31634?w=300&h=200&fit=crop', 100, true),
('Toy Train', 'Electric toy train', 900.00, 'kids', 'https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=300&h=200&fit=crop', 55, true);

-- BEAUTY (8 Products)
INSERT INTO products (name, description, price, category, image_url, stock_quantity, active) VALUES 
('Face Cream', 'Anti-aging face cream', 450.00, 'beauty', 'https://images.unsplash.com/photo-1556228578-8c89e6adf883?w=300&h=200&fit=crop', 80, true),
('Lipstick', 'Matte lipstick', 350.00, 'beauty', 'https://images.unsplash.com/photo-1586495777744-4413f21062fa?w=300&h=200&fit=crop', 100, true),
('Shampoo', 'Hair care shampoo', 250.00, 'beauty', 'https://images.unsplash.com/photo-1535585209827-a15fcdbc4c2d?w=300&h=200&fit=crop', 120, true),
('Perfume', 'Luxury perfume', 1500.00, 'beauty', 'https://images.unsplash.com/photo-1541643600914-78b084683601?w=300&h=200&fit=crop', 60, true),
('Foundation', 'Liquid foundation', 800.00, 'beauty', 'https://images.unsplash.com/photo-1522335789203-aabd1fc54bc9?w=300&h=200&fit=crop', 70, true),
('Mascara', 'Waterproof mascara', 400.00, 'beauty', 'https://images.unsplash.com/photo-1631214524020-7e18db9a8f92?w=300&h=200&fit=crop', 90, true),
('Face Wash', 'Gentle face wash', 200.00, 'beauty', 'https://images.unsplash.com/photo-1556228578-0d85b1a4d571?w=300&h=200&fit=crop', 110, true),
('Moisturizer', 'Daily moisturizer', 350.00, 'beauty', 'https://images.unsplash.com/photo-1620916566398-39f1143ab7be?w=300&h=200&fit=crop', 95, true);

-- Add coupons
INSERT INTO coupons (code, description, discount_type, discount_value, min_order_amount, max_discount_amount, valid_from, valid_until, usage_limit, used_count, active) VALUES
('WELCOME10', 'Welcome discount 10%', 'PERCENTAGE', 10.00, 100.00, 50.00, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 100, 0, true),
('SAVE50', 'Flat 50 off', 'FIXED', 50.00, 200.00, 50.00, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 50, 0, true),
('FIRST100', 'First order discount', 'FIXED', 100.00, 500.00, 100.00, NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 200, 0, true);

SELECT COUNT(*) as total_products FROM products;
SELECT category, COUNT(*) as count FROM products GROUP BY category;
