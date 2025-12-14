USE revcart_db;

-- Delete old products
DELETE FROM products;

-- Insert all products with proper images
INSERT INTO products (name, description, price, category, image_url, stock, unit, active) VALUES
-- FRUITS
('Fresh Apples', 'Fresh red apples', 120.00, 'fruits', 'https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6?w=300&h=200&fit=crop', 100, '1kg', true),
('Bananas', 'Ripe yellow bananas', 60.00, 'fruits', 'https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?w=300&h=200&fit=crop', 100, '1kg', true),
('Oranges', 'Juicy oranges', 100.00, 'fruits', 'https://images.unsplash.com/photo-1547514701-42782101795e?w=300&h=200&fit=crop', 100, '1kg', true),
('Grapes', 'Sweet grapes', 150.00, 'fruits', 'https://images.unsplash.com/photo-1537640538966-79f369143f8f?w=300&h=200&fit=crop', 100, '500g', true),
('Strawberries', 'Fresh strawberries', 200.00, 'fruits', 'https://images.unsplash.com/photo-1518635017498-87f514b751ba?w=300&h=200&fit=crop', 100, '250g', true),
('Mangoes', 'Sweet mangoes', 180.00, 'fruits', 'https://www.metropolisindia.com/upgrade/blog/upload/25/05/benefits-of-mangoes1747828357.webp', 100, '1kg', true),
('Pineapple', 'Fresh pineapple', 80.00, 'fruits', 'https://images.unsplash.com/photo-1589820296156-2454bb8a6ad1?w=300&h=200&fit=crop', 100, '1pc', true),
('Watermelon', 'Juicy watermelon', 40.00, 'fruits', 'https://images.unsplash.com/photo-1587049352846-4a222e784d38?w=300&h=200&fit=crop', 100, '1kg', true),

-- VEGETABLES
('Carrots', 'Fresh orange carrots', 40.00, 'vegetables', 'https://images.unsplash.com/photo-1445282768818-728615cc910a?w=300&h=200&fit=crop', 100, '500g', true),
('Tomatoes', 'Fresh red tomatoes', 80.00, 'vegetables', 'https://images.unsplash.com/photo-1592924357228-91a4daadcfea?w=300&h=200&fit=crop', 100, '1kg', true),
('Onions', 'Fresh onions', 30.00, 'vegetables', 'https://images.unsplash.com/photo-1508747703725-719777637510?w=300&h=200&fit=crop', 100, '1kg', true),
('Potatoes', 'Fresh potatoes', 25.00, 'vegetables', 'https://images.unsplash.com/photo-1518977676601-b53f82aba655?w=300&h=200&fit=crop', 100, '1kg', true),
('Broccoli', 'Fresh broccoli', 60.00, 'vegetables', 'https://images.unsplash.com/photo-1628773822503-930a7eaecf80?w=300&h=200&fit=crop', 100, '500g', true),
('Spinach', 'Fresh spinach leaves', 35.00, 'vegetables', 'https://images.unsplash.com/photo-1576045057995-568f588f82fb?w=300&h=200&fit=crop', 100, '250g', true),
('Bell Peppers', 'Colorful bell peppers', 70.00, 'vegetables', 'https://images.unsplash.com/photo-1563565375-f3fdfdbefa83?w=300&h=200&fit=crop', 100, '500g', true),
('Cauliflower', 'Fresh cauliflower', 45.00, 'vegetables', 'https://images.unsplash.com/photo-1594282486552-05b4d80fbb9f?w=300&h=200&fit=crop', 100, '1pc', true),

-- DAIRY
('Milk', 'Fresh cow milk', 55.00, 'dairy', 'https://nutritionsource.hsph.harvard.edu/wp-content/uploads/2024/11/AdobeStock_354060824-1024x683.jpeg', 100, '1L', true),
('Cheese', 'Fresh cheese', 200.00, 'dairy', 'https://images.unsplash.com/photo-1486297678162-eb2a19b0a32d?w=300&h=200&fit=crop', 100, '250g', true),
('Yogurt', 'Greek yogurt', 45.00, 'dairy', 'https://img.freepik.com/free-vector/realistic-vector-icon-illustration-strawberry-yoghurt-jar-with-spoon-full-yogurt-isolated_134830-2521.jpg', 100, '500g', true),
('Butter', 'Fresh butter', 120.00, 'dairy', 'https://images.unsplash.com/photo-1589985270826-4b7bb135bc9d?w=300&h=200&fit=crop', 100, '200g', true),
('Cream', 'Heavy cream', 80.00, 'dairy', 'https://www.realsimple.com/thmb/WIQw_c6ePyPKkXAGrFVB5hvMN_A=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/make-sour-cream-2000-513d49b3aaba4708a67b19380cc32de6.jpg', 100, '200ml', true),
('Ice Cream', 'Vanilla ice cream', 150.00, 'dairy', 'https://images.unsplash.com/photo-1567206563064-6f60f40a2b57?w=300&h=200&fit=crop', 100, '500ml', true),
('Paneer', 'Fresh paneer', 180.00, 'dairy', 'https://chennaionlineshopping.in/image/cache/catalog/Products/panner/amul%20panner-800x800.jpg', 100, '250g', true),
('Ghee', 'Pure cow ghee', 300.00, 'dairy', 'https://ueirorganic.com/cdn/shop/files/purecowghee.jpg?v=1689066451', 100, '500ml', true),

-- BAKERY
('Bread', 'Whole wheat bread', 35.00, 'bakery', 'https://assets.bonappetit.com/photos/5c62e4a3e81bbf522a9579ce/1:1/pass/milk-bread.jpg', 100, '1loaf', true),
('Croissant', 'Buttery croissant', 25.00, 'bakery', 'https://sugargeekshow.com/wp-content/uploads/2022/11/croissants_featured.jpg', 100, '1pc', true),
('Muffins', 'Blueberry muffins', 80.00, 'bakery', 'https://images.unsplash.com/photo-1607958996333-41aef7caefaa?w=300&h=200&fit=crop', 100, '4pcs', true),
('Cookies', 'Chocolate cookies', 60.00, 'bakery', 'https://images.unsplash.com/photo-1499636136210-6f4ee915583e?w=300&h=200&fit=crop', 100, '6pcs', true),
('Donuts', 'Glazed donuts', 120.00, 'bakery', 'https://images.unsplash.com/photo-1551024506-0bccd828d307?w=300&h=200&fit=crop', 100, '6pcs', true),
('Cake', 'Chocolate cake', 400.00, 'bakery', 'https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=300&h=200&fit=crop', 100, '1pc', true),
('Bagels', 'Fresh bagels', 90.00, 'bakery', 'https://www.tasteofhome.com/wp-content/uploads/2025/01/Homemade-Bagels_EXPS_TOHD25_15702_ChristineMa_9.jpg', 100, '4pcs', true),
('Pastry', 'Fruit pastry', 50.00, 'bakery', 'https://krbakes.com/cdn/shop/articles/Top_10_Trending_Pastry_Cakes_You_Need_to_Try.webp', 100, '1pc', true),

-- ELECTRONICS
('Smartphone', 'Latest smartphone', 15000.00, 'electronics', 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=300&h=200&fit=crop', 100, '1pc', true),
('Headphones', 'Wireless headphones', 2500.00, 'electronics', 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=300&h=200&fit=crop', 100, '1pc', true),
('Laptop', 'Gaming laptop', 45000.00, 'electronics', 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=300&h=200&fit=crop', 100, '1pc', true),
('Smart Watch', 'Fitness smart watch', 8000.00, 'electronics', 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=300&h=200&fit=crop', 100, '1pc', true),
('Tablet', '10-inch tablet', 20000.00, 'electronics', 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=300&h=200&fit=crop', 100, '1pc', true),
('Power Bank', '10000mAh power bank', 1500.00, 'electronics', 'https://i03.appmifile.com/333_item_in/08/07/2025/9047b35e12fa25cb45fc93a824a29e87.jpg', 100, '1pc', true),
('Bluetooth Speaker', 'Portable speaker', 3000.00, 'electronics', 'https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=300&h=200&fit=crop', 100, '1pc', true),
('Wireless Mouse', 'Ergonomic wireless mouse', 800.00, 'electronics', 'https://m.media-amazon.com/images/I/51vMo-pHZ5L.jpg', 100, '1pc', true),

-- SPORTS
('Football', 'Professional football', 800.00, 'sports', 'https://images.unsplash.com/photo-1486286701208-1d58e9338013?w=300&h=200&fit=crop', 100, '1pc', true),
('Cricket Bat', 'Professional cricket bat', 1200.00, 'sports', 'https://dkpcricketonline.com/cdn/shop/collections/image_419d887e-bcd5-4469-9925-776dc84db52b.heic', 100, '1pc', true),
('Cricket Ball', 'Leather cricket ball', 300.00, 'sports', 'https://nwscdn.com/media/catalog/product/cache/h400xw400/c/r/cricket-club-ball-family_1.jpg', 100, '1pc', true),
('Tennis Racket', 'Professional tennis racket', 1500.00, 'sports', 'https://us.yonex.com/cdn/shop/files/CLP_Tennis_Ezone_D.jpg', 100, '1pc', true),
('Basketball', 'Professional basketball', 900.00, 'sports', 'https://static.nbastore.in/resized/900X900/1180/wilson-nba-mens-drv-pro-basketball-brown-brown-68dc39e5a64de.jpg', 100, '1pc', true),
('Badminton Racket', 'Lightweight badminton racket', 800.00, 'sports', 'https://cdn.firstcry.com/education/2022/07/25185734/Essay-On-My-Favourite-Game-Badminton-10-Lines-Short-and-Long-Essay-For-Kids.jpg', 100, '1pc', true),
('Table Tennis Paddle', 'Professional table tennis paddle', 400.00, 'sports', 'https://m.media-amazon.com/images/I/81OnewcSyTL.jpg', 100, '1pc', true),
('Volleyball', 'Professional volleyball', 600.00, 'sports', 'https://m.media-amazon.com/images/I/61pFab9tNeL.jpg', 100, '1pc', true),
('Yoga Mat', 'Premium yoga mat', 600.00, 'sports', 'https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=300&h=200&fit=crop', 100, '1pc', true),
('Dumbbells', 'Adjustable dumbbells', 2000.00, 'sports', 'https://www.vinexshop.com/Product-Images/Large/2150-Dumbbells-Iron.jpg', 100, '1pair', true),
('Swimming Goggles', 'Anti-fog swimming goggles', 350.00, 'sports', 'https://rukminim2.flixcart.com/image/356/352/xif0q/goggle/r/i/s/-original-imahe3kahqp5zyfy.jpeg', 100, '1pc', true),
('Boxing Gloves', 'Professional boxing gloves', 1800.00, 'sports', 'https://m.media-amazon.com/images/I/81MThv+hgeS.jpg', 100, '1pair', true),

-- KIDS
('Teddy Bear', 'Soft teddy bear', 500.00, 'kids', 'https://tse1.mm.bing.net/th/id/OIP.IQUsCBaKM8Ox51lI1XH5BAHaFR?pid=Api&P=0&h=180', 100, '1pc', true),
('Building Blocks', 'Colorful building blocks', 800.00, 'kids', 'https://baybee.co.in/cdn/shop/files/71Z7Rwn2BGL._SL1500.jpg', 100, '1set', true),
('Puzzle Game', 'Educational puzzle', 300.00, 'kids', 'https://images.unsplash.com/photo-1601987177651-8edfe6c20009?fm=jpg&q=60&w=3000', 100, '1pc', true),
('Remote Car', 'RC racing car', 1200.00, 'kids', 'https://cdn-gnhif.nitrocdn.com/TVcQuMoyCLAXtNubQjipHiuZSBgcXCHY/assets/images/optimized/rev-b921d37/www.daddydrones.in/image/cache/catalog/HOSPEED/HS16351/FRONT/image0-500x500.jpeg', 100, '1pc', true),

-- BEAUTY
('Face Cream', 'Anti-aging face cream', 450.00, 'beauty', 'https://dr.rashel.in/cdn/shop/products/Vitamin_C_Face_Cream.jpg', 100, '50ml', true),
('Lipstick', 'Matte lipstick', 350.00, 'beauty', 'https://images-static.nykaa.com/media/catalog/product/b/5/b560771773602685189_2.png', 100, '1pc', true),
('Shampoo', 'Hair care shampoo', 250.00, 'beauty', 'https://barcodeprofessional.in/cdn/shop/files/01_7aaa4ca4-6c4e-44f7-816f-86b2f49489ef.jpg', 100, '200ml', true),
('Perfume', 'Luxury perfume', 1500.00, 'beauty', 'https://images.pexels.com/photos/1961791/pexels-photo-1961791.jpeg', 100, '100ml', true),
('Foundation', 'Liquid foundation', 800.00, 'beauty', 'https://media6.ppl-media.com//tr:h-235,w-235,c-at_max,dpr-2,q-40/static/img/product/344732/ny-bae-3-in-1-primer-foundation-serum-warm-cashew-03-30-ml-82_1_display_1754664234_9f6773f8.jpg', 100, '30ml', true),
('Mascara', 'Waterproof mascara', 400.00, 'beauty', 'https://www.lakmeindia.com/cdn/shop/files/29112_H-8901030859073_800x.jpg', 100, '1pc', true),
('Face Wash', 'Gentle face wash', 200.00, 'beauty', 'https://www.pinkroot.in/cdn/shop/files/orange-face-wash-for-tan-removalor-pimple-control-100ml-pink-root-1.png', 100, '150ml', true),
('Moisturizer', 'Daily moisturizer', 350.00, 'beauty', 'https://plumgoodness.com/cdn/shop/files/nia-gel-moodshot-website.jpg', 100, '100ml', true),

-- MENS CLOTHING
('Cotton T-Shirt', 'Comfortable cotton t-shirt', 299.00, 'mens-clothing', 'https://tse4.mm.bing.net/th/id/OIP.cqRySj1nLdqPOfPVlap5qgHaLW?pid=Api&P=0&h=180', 100, '1pc', true),
('Formal Shirt', 'Professional formal shirt', 799.00, 'mens-clothing', 'https://tse2.mm.bing.net/th/id/OIP.3ofWlPcJ3FJ3Xrgr2iRzwwHaJ4?pid=Api&P=0&h=180', 100, '1pc', true),
('Denim Jeans', 'Classic blue denim jeans', 1299.00, 'mens-clothing', 'https://tse4.mm.bing.net/th/id/OIP.pheyq3kHKDYGzckJpWRi4wHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Casual Pants', 'Comfortable casual pants', 899.00, 'mens-clothing', 'https://sp.yimg.com/ib/th?id=OPAC.jT1rDnm3XsP4Iw474C474&o=5&pid=21.1&w=160&h=105', 100, '1pc', true),
('Polo Shirt', 'Classic polo shirt', 599.00, 'mens-clothing', 'https://tse3.mm.bing.net/th/id/OIP.pclAm4_GBk7aYP1HULgsWgHaJ4?pid=Api&P=0&h=180', 100, '1pc', true),
('Jacket', 'Stylish winter jacket', 2499.00, 'mens-clothing', 'https://tse2.mm.bing.net/th/id/OIP.yHeda13jtfKxzqQIXOzvxAHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Shorts', 'Comfortable shorts', 499.00, 'mens-clothing', 'https://sp.yimg.com/ib/th?id=OPAC.Fm2MJ%2fEfNZBRLw474C474&o=5&pid=21.1&w=174&h=174', 100, '1pc', true),
('Sweater', 'Cozy wool sweater', 1199.00, 'mens-clothing', 'https://tse4.mm.bing.net/th/id/OIP.vy8DaDyYm2wrBxHgRYN4XwHaHa?pid=Api&P=0&h=180', 100, '1pc', true),

-- WOMENS CLOTHING
('Women T-Shirt', 'Stylish women t-shirt', 349.00, 'womens-clothing', 'https://tse2.mm.bing.net/th/id/OIP.qjqCdnkVUrbs5nGrmo3mjAHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Women Jeans', 'Trendy women jeans', 1399.00, 'womens-clothing', 'https://tse3.mm.bing.net/th/id/OIP.E7ZUHS6umF9WT-hUGreqPQHaJc?pid=Api&P=0&h=180', 100, '1pc', true),
('Saree', 'Traditional saree', 1999.00, 'womens-clothing', 'https://tse1.mm.bing.net/th/id/OIP.SK-4JOkusXRrK_aSCAKs3gHaJ4?pid=Api&P=0&h=180', 100, '1pc', true),
('Kurti', 'Ethnic kurti', 799.00, 'womens-clothing', 'https://blog.g3fashion.com/wp-content/uploads/2021/07/111-1170x1560.jpg', 100, '1pc', true),
('Dress', 'Elegant dress', 1299.00, 'womens-clothing', 'https://tse1.mm.bing.net/th/id/OIP.xhRpcpBfh3NwUcJUvz0llQHaJ4?pid=Api&P=0&h=180', 100, '1pc', true),
('Leggings', 'Comfortable leggings', 499.00, 'womens-clothing', 'https://tse2.mm.bing.net/th/id/OIP.cw7pnMiztlqG-QZOX42jUgHaI7?pid=Api&P=0&h=180', 100, '1pc', true),
('Skirt', 'Stylish skirt', 899.00, 'womens-clothing', 'https://tse3.mm.bing.net/th/id/OIP.NErfEe7vsMwcbiCiTBGn3gHaLG?pid=Api&P=0&h=180', 100, '1pc', true),
('Blazer', 'Professional blazer', 2199.00, 'womens-clothing', 'https://tse4.mm.bing.net/th/id/OIP.eO6O3bJju3IfjWh_GJw_nQHaKV?pid=Api&P=0&h=180', 100, '1pc', true),

-- KIDS CLOTHING
('Kids T-Shirt', 'Colorful kids t-shirt', 249.00, 'kids-clothing', 'https://tse2.mm.bing.net/th/id/OIP.lRLXS7hjKeGCV9ue4ViLbwHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Kids Jeans', 'Durable kids jeans', 699.00, 'kids-clothing', 'https://tse4.mm.bing.net/th/id/OIP.7wCx-GAqoV4G0ZYIRjIGKQHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Kids Dress', 'Pretty kids dress', 599.00, 'kids-clothing', 'https://tse3.mm.bing.net/th/id/OIP.ZBiF3wEgTdonJSOiUXqu-QHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Kids Shorts', 'Comfortable kids shorts', 399.00, 'kids-clothing', 'https://tse4.mm.bing.net/th/id/OIP.-IC1V0j5a8vZ0FlRXq7cjAHaHX?pid=Api&P=0&h=180', 100, '1pc', true),
('Kids Jacket', 'Warm kids jacket', 1299.00, 'kids-clothing', 'https://tse3.mm.bing.net/th/id/OIP.KhMeoHWJNcavzwP1iRdQHwHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Kids Sweater', 'Cozy kids sweater', 699.00, 'kids-clothing', 'https://tse4.mm.bing.net/th/id/OIP.Gs_oqoEofbdCG7SoFdLHkgHaHa?pid=Api&P=0&h=180', 100, '1pc', true),
('Kids Shoes', 'Comfortable kids shoes', 799.00, 'kids-clothing', 'https://tse1.mm.bing.net/th/id/OIP.8ReQe1mfH7hW84Zz93wV_gHaIp?pid=Api&P=0&h=180', 100, '1pair', true),
('Kids Socks', 'Colorful kids socks', 199.00, 'kids-clothing', 'https://tse2.mm.bing.net/th/id/OIP.CNTzI8ORJG4hEeDrs_sD5gHaHa?pid=Api&P=0&h=180', 100, '3pairs', true);
