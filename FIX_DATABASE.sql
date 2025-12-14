-- Fix products table
UPDATE revcart_db.products SET created_at = NOW() WHERE created_at = '0000-00-00 00:00:00' OR created_at IS NULL;
UPDATE revcart_db.products SET updated_at = NOW() WHERE updated_at = '0000-00-00 00:00:00' OR updated_at IS NULL;

-- Or drop and recreate
-- DROP TABLE revcart_db.products;
