DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    gender CHAR(1),
    name VARCHAR(25) NOT NULL,
    birthday DATE NOT NULL,
    country VARCHAR(50) NOT NULL,
    phone INT
);