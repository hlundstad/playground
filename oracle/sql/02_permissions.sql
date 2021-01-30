ALTER SESSION SET CONTAINER = ORCLPDB1;

GRANT CONNECT TO test_user CONTAINER=CURRENT;
GRANT CREATE SESSION TO test_user CONTAINER=CURRENT;
GRANT RESOURCE TO test_user CONTAINER=CURRENT;

GRANT CONNECT TO flyway_user CONTAINER=CURRENT;
GRANT CREATE SESSION TO flyway_user CONTAINER=CURRENT;
GRANT RESOURCE TO flyway_user CONTAINER=CURRENT;

ALTER USER test_user QUOTA 100M ON USERS;
ALTER USER flyway_user QUOTA 100M ON USERS;
