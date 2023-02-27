DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    gender VARCHAR,
    name VARCHAR NOT NULL,
    birthday DATE NOT NULL,
    country VARCHAR NOT NULL,
    phone VARCHAR NOT NULL
);