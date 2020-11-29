ALTER SESSION SET CONTAINER = ORCLPDB1;
ALTER SESSION SET CURRENT_SCHEMA = test_user;

-- --DROP TABLE IF EXISTS provider;
-- BEGIN
--   EXECUTE IMMEDIATE 'DROP TABLE provider';
-- EXCEPTION
--   WHEN OTHERS THEN
--     NULL;
-- END;



CREATE TABLE provider (id NUMBER(10) NOT NULL,firstName VARCHAR(250) NOT NULL,lastName VARCHAR(250) NOT NULL,email VARCHAR(250) DEFAULT NULL);



ALTER TABLE provider
  ADD (
    CONSTRAINT provider_pk PRIMARY KEY (id)
  );


CREATE SEQUENCE provider_sequence 
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 20
;

INSERT INTO provider (id,firstName, lastName, email) VALUES
(provider_sequence.nextval,'Aliko', 'Dangote', 'fol@gmail1.com');
INSERT INTO provider (id,firstName, lastName, email) VALUES
(provider_sequence.nextval,'Bill', 'Gates', 'fol@gmail1.com');
INSERT INTO provider (id,firstName, lastName, email) VALUES
(provider_sequence.nextval,'Folrunsho', 'Alakija', 'fol@gmail1.com');

commit ;

