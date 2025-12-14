-- Connect to MySQL and run this
USE product_service_db;

INSERT INTO product (name, description, price, category, stock_quantity, image_url, rating) VALUES
('Laptop', 'High performance laptop', 999.99, 'Electronics', 50, 'https://via.placeholder.com/300', 4.5),
('Smartphone', 'Latest smartphone', 699.99, 'Electronics', 100, 'https://via.placeholder.com/300', 4.7),
('Headphones', 'Wireless headphones', 149.99, 'Electronics', 200, 'https://via.placeholder.com/300', 4.3),
('T-Shirt', 'Cotton t-shirt', 19.99, 'Clothing', 500, 'https://via.placeholder.com/300', 4.0),
('Jeans', 'Blue denim jeans', 49.99, 'Clothing', 300, 'https://via.placeholder.com/300', 4.2),
('Running Shoes', 'Comfortable running shoes', 79.99, 'Footwear', 150, 'https://via.placeholder.com/300', 4.6),
('Watch', 'Smart watch', 299.99, 'Accessories', 75, 'https://via.placeholder.com/300', 4.4),
('Backpack', 'Travel backpack', 59.99, 'Accessories', 120, 'https://via.placeholder.com/300', 4.1);
