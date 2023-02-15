DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  gender CHAR(1),
  name VARCHAR(25) NOT NULL,
  birthday DATE NOT NULL,
  country VARCHAR(50) NOT NULL,
  phone INT
);
 
INSERT INTO users (gender, name, birthday, country, phone) VALUES
  ('0', 'Jule', '1983-08-17', 'france', '0610203040'),
  ('1', 'Laurent', '2022-10-29', 'espagne', '0620304050'),
  ('2', 'Mathilde', '1983-08-17', 'france', '0720304050'),
  ('3', 'Laura', '1983-08-17', 'france', '0720304050');

