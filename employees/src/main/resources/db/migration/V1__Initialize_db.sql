ALTER SESSION SET CONTAINER = ORCLPDB1;

CREATE TABLE employee (
    id INT NOT NULL,
    firstName VARCHAR2(250),
    lastName VARCHAR2(250),
    email VARCHAR2(250)
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
