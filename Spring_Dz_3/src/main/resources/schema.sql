CREATE TABLE IF NOT EXISTS "user"
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age  int NOT NULL,
    email varchar(50) not null
);

INSERT INTO "user" (name, age, email) values ('John', 33, 'ivan@gmail.com');
INSERT INTO "user" (name, age, email) values ('Dave', 31, 'serg@gmail.com');
