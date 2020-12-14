INSERT INTO employee (id,firstName, lastName, email) VALUES
(employee_sequence.nextval,'Donald', 'Duck', 'duck@gmail1.com');
INSERT INTO employee_address (id,employee_id, street, postnumber, mobile) VALUES
(employee_address_sequence.nextval,employee_sequence.currval, 'Kvakkeveien 1',1000, '010203040');
INSERT INTO employee_address (id,employee_id, street, postnumber, mobile) VALUES
(employee_address_sequence.nextval,employee_sequence.currval, 'Hytteveien 100',1000, '11022304');


INSERT INTO employee (id,firstName, lastName, email) VALUES
(employee_sequence.nextval,'Dolly', 'Duck', 'dolly@gmail1.com');
INSERT INTO employee_address (id,employee_id, street, postnumber, mobile) VALUES
(employee_address_sequence.nextval,employee_sequence.currval, 'Apalveien 50',1000, '11223344');

INSERT INTO employee (id,firstName, lastName, email) VALUES
(employee_sequence.nextval,'Mickey', 'Mouse', 'mouse@gmail1.com');
INSERT INTO employee_address (id,employee_id, street, postnumber, mobile) VALUES
(employee_address_sequence.nextval,employee_sequence.currval, 'Kattehuset 10',1000, '11122233');





