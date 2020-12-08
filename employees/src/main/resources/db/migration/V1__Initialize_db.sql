ALTER SESSION SET CONTAINER = ORCLPDB1;

CREATE TABLE employee (
    id INT NOT NULL,
    firstName VARCHAR(250) NOT NULL,
    lastName VARCHAR(250) NOT NULL,
    email VARCHAR(250) DEFAULT NULL
                      );

ALTER TABLE employee
    ADD (
        CONSTRAINT employee_pk PRIMARY KEY (id)
        );


CREATE SEQUENCE employee_sequence
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20
;

INSERT INTO employee (id,firstName, lastName, email) VALUES
(employee_sequence.nextval,'Donald', 'Duck', 'duck@gmail1.com');
INSERT INTO employee (id,firstName, lastName, email) VALUES
(employee_sequence.nextval,'Dolly', 'Duck', 'dolly@gmail1.com');
INSERT INTO employee (id,firstName, lastName, email) VALUES
(employee_sequence.nextval,'Mickey', 'Mouse', 'mouse@gmail1.com');

COMMIT;