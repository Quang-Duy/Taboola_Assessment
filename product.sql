DROP DATABASE IF EXISTS assessment;
CREATE DATABASE assessment;
USE assessment;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_price_history;


create table products (
    productID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(15) NOT NULL
);

create table product_price_history (
    productID INT NOT NULL,
    price FLOAT NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE,
    FOREIGN KEY (productID) REFERENCES products (productID) ON DELETE CASCADE
);

INSERT INTO products (name, category) VALUES ('tee-shirt', 'clothing');
INSERT INTO products (name, category) VALUES ('necklace', 'accessory');
INSERT INTO product_price_history (productID, price, startDate, endDate) VALUES (1, 20.99, '2021-12-10', '2022-12-09');
INSERT INTO product_price_history (productID, price, startDate) VALUES (2, 119.99, '2021-12-25');

SELECT * FROM products;
SELECT * FROM product_price_history;

SELECT * FROM products NATURAL JOIN product_price_history;