-- Create table if not exists
CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100),
    price REAL,
    stock INTEGER
);

-- Insert data (use ON CONFLICT DO NOTHING if id might collide)
INSERT INTO product (name, category, price, stock)
VALUES
    ('Macbook Air M2', 'Laptop', 1099.99, 20),
    ('iPhone 14', 'Phone', 999.99, 30),
    ('iPad Pro', 'Tablet', 799.99, 15)
ON CONFLICT DO NOTHING;
