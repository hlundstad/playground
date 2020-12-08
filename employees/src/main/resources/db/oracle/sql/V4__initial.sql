DROP TABLE IF EXISTS provider;

CREATE TABLE employee (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          firstName VARCHAR(250) NOT NULL,
                          lastName VARCHAR(250) NOT NULL,
                          email VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (firstName, lastName, email) VALUES
('Steve', 'Jobs', 'steve.jobs@gmail1.com'),
('Steve', 'Wozniak', 'steve.wozniak@gmail1.com'),
('Ronald', 'Wayne', 'ronald.wayne@gmail1.com');