-- DROP IF EXISTS customers;
CREATE TABLE customers (
                           Id INT AUTO_INCREMENT PRIMARY KEY,
                           firstname VARCHAR(50) NOT NULL,
                           lastname  VARCHAR(50) NOT NULL
);