CREATE DATABASE internet_shop;

DROP TABLE internet_shop.products;
DROP TABLE internet_shop.product_type;
DROP TABLE internet_shop.producer;

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

CREATE TABLE internet_shop.products
(
    id SERIAL NOT NULL CONSTRAINT product_id PRIMARY KEY ,
    type INTEGER REFERENCES internet_shop.product_type(id) NOT NULL ,
    name VARCHAR(40) NOT NULL ,
    producer INTEGER REFERENCES internet_shop.producer(id) NOT NULL ,
    description text default 'none',
    price NUMERIC NOT NULL
);


INSERT INTO internet_shop.product_type (name) VALUES
 ('TV'),
 ('PC') ,
 ('Notebook') ,
 ('Refrigerator') ,
 ('Watch') ,
 ('Smartphone') ,
 ('Electric kettle');



INSERT INTO internet_shop.producer (name) VALUES
  ('Sony'),
  ('Toshiba'),
  ('Panasonik'),
  ('Siemens'),
  ('Bosch'),
  ('Apple'),
  ('LG'),
  ('Dell'),
  ('Sputnik');

INSERT INTO internet_shop.products (type, name, producer, description, price) VALUES
(2,'GNO-0345',6,'display: 13"; resolution: 2160×1440; IPS; Intel Core i5 8265U',1230.50),
(4, 'ICO-9000', 5, 'very big, white', 350.60),
(1, 'Vomey-006', 1, 'Paratron, Hi-Fi stereo', 600.00),
(1, 'Pure view G018-354 v.2', 3, 'Black, flat and cool TV', 1430.45),
(6, 'MAX 11', 6, 'color: black antracyt', 2500.00),
(3, 'GFH 34f', 1, 'color: simple white', 2500.00),
(3, 'GGH-09994b', 7, 'color: yellow', 1700.00),
(4, 'MKL-03', 5, 'color: blue', 750.00),
(4, 'RTY-1288', 5, 'color: yellow', 300.00),
(5, 'MBK-extpreeme', 6, 'color: pirple', 3700.00),
(5, 'MBK-sypreme', 6, 'color: white', 6700.00),
(4, 'BBN-34', 9, 'color: black', 100.00),
(2, 'Gamer dream', 8, 'display: 26"; resolution: 3160×2440; IPS; Intel Core i5 8770H', 1167.00),
(2, 'Gamer dream-2', 8, 'display: 15"; resolution: 3160×1440; IPS; Intel Core i5 855U', 3105.00),
(2, 'Gamer dream-3 GNO-003', 8, 'display: 17"; resolution: 3160×2440; FLAT IPS; Ryzen 2600K', 4105.00),
(6, 'Zero might - 1', 7, 'color: black', 405.00),
(6, 'BestoPhone', 7, 'color: dark', 302.10),
(1, 'Pure view G014-3443 v.3', 7, 'Black', 880.35),
(1, 'Pure view G016-997 v.17', 8, 'flat and black', 740.25),
(7, 'Hot tube xtreem m-2', 4, 'color: pirple', 22.10),
(7, 'MBK-fast NML0034-2 v2', 4, 'color: grey', 28.00),
(7, 'Z-travalier', 4, 'color: black', 14.00),
(2, 'Monsre mad PC', 1, 'display: 15"; resolution: 2160×1440; IPS; Intel Core i5 8545U', 2430.45);


