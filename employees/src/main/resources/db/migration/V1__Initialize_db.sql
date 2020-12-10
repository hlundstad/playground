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

create or replace TRIGGER trigger_insertEmployee
    BEFORE INSERT ON employee
    FOR EACH ROW
DECLARE
BEGIN
    IF( :new.id IS NULL )
    THEN
        :new.id := EMPLOYEE_SEQUENCE.nextval;
    END IF;
END;
