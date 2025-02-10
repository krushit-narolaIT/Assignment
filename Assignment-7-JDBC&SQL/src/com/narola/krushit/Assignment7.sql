-- Multi-Table Queries: Create JOIN queries to combine data from multiple tables.

CREATE DATABASE sql_my_learn;

USE sql_my_learn;

CREATE TABLE countries (
    country_code VARCHAR(5) PRIMARY KEY,
    country_name VARCHAR(100) UNIQUE,
    continent VARCHAR(50),
    population BIGINT CHECK (population > 0),
    capital VARCHAR(100)
);

CREATE TABLE country_stats (
	country_id INT PRIMARY KEY AUTO_INCREMENT,
    country_code VARCHAR(5),
    gdp BIGINT, -- in USD
    area BIGINT, -- in sq. km
    currency VARCHAR(50)
);

INSERT INTO countries (country_code, country_name, continent, population, capital) VALUES
('USA', 'United States of America', 'North America', 345426571, 'Washington, D.C.'),
('CAN', 'Canada', 'North America', 29123744, 'Ottawa'),
('BRA', 'Brazil', 'South America', 211998573, 'Brasilia'),
('DEU', 'Germany', 'Europe', 83783942, 'Berlin'),
('IND', 'India', 'Asia', 1450935791, 'New Delhi'),
('CHN', 'China', 'Asia', 1419321278, 'Beijing'),
('AUS', 'Australia', 'Oceania', 26713205, 'Canberra'),
('QAT', 'Qatar', 'Asia', 3088462, 'Doha'),
('ZAF', 'South Africa', 'Africa', 59308690, 'Pretoria');

INSERT INTO country_stats (country_code, gdp, area, currency) VALUES
('USA', 2600000000000, 9833517, 'USD'),
('CAN', 220000000000, 9984670, 'USD'),
('DEU', 420000000000, 357022, 'EUR'),
('IND', 330000000000, 3287263, 'INR'),
('CHN', 1770000000000, 9596961, 'CNY'),
('QAT', 2357700000, 11571, 'QAR'),
('AUS', 170000000000, 7692024, 'AUD');

-- Find all countries along with their currencies
SELECT c.country_name, c.continent, c.capital, s.currency 
FROM countries AS c
INNER JOIN country_stats AS s
WHERE c.country_code = s.country_code;

SELECT c.country_name, c.continent, c.capital, s.currency, s.gdp
FROM countries AS c
INNER JOIN country_stats AS s
WHERE c.country_code = s.country_code AND s.gdp > 100;

-- left join
SELECT * FROM countries AS c
LEFT JOIN country_stats AS s
ON c.country_code = s.country_code;

-- left outer join
SELECT * FROM countries AS c
LEFT OUTER JOIN country_stats AS s
ON c.country_code = s.country_code;

-- Aggregation: Write queries using GROUP BY, performing calculations on grouped data.
-- Group by Country Continent
SELECT c.continent, COUNT(c.continent) AS number_of_countries FROM countries AS c
LEFT JOIN country_stats AS s
ON c.country_code = s.country_code
GROUP BY c.continent;

-- Group by Country
SELECT c.continent, COUNT(c.continent) AS number_of_countries FROM countries AS c
LEFT JOIN country_stats AS s
ON c.country_code = s.country_code
GROUP BY c.continent;

-- Constraints
-- Add a UNIQUE constraint to a table and try inserting duplicate values.
-- Add a CHECK constraint and attempt inserting invalid data.

-- Error Code: 1062. Duplicate entry 'USA' for key 'countries.PRIMARY'
INSERT INTO countries (country_code, country_name, continent, population, capital) VALUES
('USA', 'United States of America', 'North America', 345426571, 'Washington, D.C.');

-- Error Code: 3819. Check constraint 'countries_chk_1' is violated.
INSERT INTO countries (country_code, country_name, continent, population, capital) VALUES
('JPN', 'Japan', 'Asia', 0, 'Tokyo');


-- Composite Indexes
-- Create a composite index for a table.
-- Execute queries before and after adding an index.
-- Observe execution time differences using EXPLAIN ANALYZE (if supported by DB).

CREATE TABLE employees (
    employee_number INT PRIMARY KEY,
	first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(100),
    salary DECIMAL(10,2)
);

INSERT INTO employees (employee_number, first_name, last_name, email, phone, salary) VALUES
(1, 'John', 'Ceha', 'john@gmail.com', '785694', 55000.00),
(2, 'Janny', 'Dave', 'janny@gmail.com', '456321', 62000.00),
(3, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(4, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(5, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(6, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(7, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(8, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(9, 'Janny', 'Patterson', 'janny@gmail.com', '456321', 62000.00),
(10, 'Janny', 'Ami', 'janny@gmail.com', '456321', 62000.00);

EXPLAIN SELECT first_name, last_name, email
FROM employees
WHERE last_name = 'Ami';

CREATE INDEX name 
ON employees(first_name, last_name);

SELECT first_name, last_name, email
FROM employees
WHERE last_name = 'Rogers';

EXPLAIN SELECT first_name, last_name, email
FROM employees
WHERE last_name = 'Ami';

-- Transactions: Perform a sequence of DML statements under a transaction, and rollback if needed.
SET autocommit = FALSE;

COMMIT;
BEGIN;

INSERT INTO employees (employee_number, first_name, last_name, email, phone) VALUES
(15, 'abc', 'Ceha', 'john@gmail.com', '785694'),
(16, 'def', 'Dave', 'janny@gmail.com', '456321'),
(17, 'ghi', 'Ami', 'janny@gmail.com', '456321');

ROLLBACK;

SELECT * FROM employees;