CREATE DATABASE internet_shop;

DROP TABLE internet_shop.product;
DROP TABLE internet_shop.producer;
DROP TABLE internet_shop.description;
DROP TABLE internet_shop.product_name;

CREATE TABLE internet_shop.product_type
(
    id SERIAL NOT NULL CONSTRAINT product_type_id PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);


CREATE TABLE internet_shop.producer
(
    id SERIAL NOT NULL CONSTRAINT producer_id PRIMARY KEY ,
    name VARCHAR(50)
);
CREATE TABLE internet_shop.description
(
    id SERIAL NOT NULL CONSTRAINT description_id PRIMARY KEY ,
    description text
);

CREATE TABLE internet_shop.product
(
    id SERIAL NOT NULL CONSTRAINT product_id PRIMARY KEY ,
    name INTEGER NOT NULL references internet_shop.product_name(id),
    producer INTEGER REFERENCES internet_shop.producer(id) NOT NULL ,
    description INTEGER REFERENCES internet_shop.description(id),
    price NUMERIC NOT NULL NOT NULL
);

INSERT INTO internet_shop.product_name (name) VALUES
('refrigerator'),('tv'),('table'),('shoes'),('personal computer'),('microwave'),('shower'),('lamp');
INSERT INTO internet_shop.producer (name) VALUES
('Sony'),('Panasonic'),('Siemens'),('Ikea'),('Adidas');
INSERT INTO internet_shop.description (description) VALUES
('Сделано в Германии'), ('Сделано в России'), ('Сделано в Китае'), ('Сделано в Словакии'), ('Сделано в США');

INSERT INTO internet_shop.product (name, producer, description, price) VALUES
(2, 3,1,225.50), (5, 3, 3, 1250.00), (4, 5, 3, 22.70), (1, 2, 4, 340.00), (8, 4, 5,15.40),
(3, 4, 1,7.99), (6, 3, 5,174.00),(7, 2, 1,38.99);