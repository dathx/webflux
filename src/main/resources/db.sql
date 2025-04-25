CREATE TABLE Account (
                         accountId VARCHAR(8) PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         age INTEGER CHECK (age >= 0),
                         email VARCHAR(255) UNIQUE NOT NULL
);


INSERT INTO Account (accountId, name, age, email) VALUES
                                                      ('AC000001', 'Alice Nguyen', 25, 'alice@example.com'),
                                                      ('AC000002', 'Bob Tran', 30, 'bob@example.com'),
                                                      ('AC000003', 'Charlie Le', 28, 'charlie@example.com'),
                                                      ('AC000004', 'Diana Pham', 22, 'diana@example.com'),
                                                      ('AC000005', 'Ethan Vo', 35, 'ethan@example.com');

select * from Account