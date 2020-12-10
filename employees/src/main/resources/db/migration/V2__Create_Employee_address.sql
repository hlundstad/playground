CREATE TABLE employee_address
(   id numeric(10) not nulL,
    employee_id INT NOT NULL,
    street VARCHAR2(250) ,
    postnumber numeric(4),
    mobile numeric(8),
    CONSTRAINT employee_address_pk PRIMARY KEY (id),
    CONSTRAINT fk_employee
        FOREIGN KEY (employee_id)
            REFERENCES employee(id)
);


CREATE SEQUENCE employee_address_sequence
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20
;

