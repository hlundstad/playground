DROP TABLE IF EXISTS provider;

CREATE TABLE provider (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          firstName VARCHAR(250) NOT NULL,
                          lastName VARCHAR(250) NOT NULL,
                          email VARCHAR(250) DEFAULT NULL
);

INSERT INTO provider (firstName, lastName, email) VALUES
('Aliko', 'Dangote', 'fol@gmail1.com'),
('Bill', 'Gates', 'fol@gmail1.com'),
('Folrunsho', 'Alakija', 'fol@gmail1.com');