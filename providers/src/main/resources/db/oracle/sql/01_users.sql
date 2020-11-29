ALTER SESSION SET CONTAINER = ORCLPDB1;

CREATE USER test_user IDENTIFIED BY "oracle123";


--- Change session to Pluggable DataBase (PDB)
--ALTER SESSION SET container = ORALFRDEVPDB;
-- Create tablespace for schema Liferay 7.2 GA2
--CREATE TABLESPACE liferay\_dev\_72\_ga2\_data logging DATAFILE'/opt/oracle/oradata/ORALFRDEV/ORALFRDEVPDB/liferay\_dev\_72\_ga2\_data.dbf' SIZE 64mautoextend ON NEXT 32m maxsize 4096m blocksize 8k EXTENT management local;
--Create temp tablespace for Liferay 7.2 GA2
--CREATE TEMPORARY TABLESPACE liferay\_dev\_72\_ga2\_temp tempfile '/opt/oracle/oradata/ORALFRDEV/ORALFRDEVPDB/liferay\_dev\_72\_ga2\_temp.dbf' SIZE 64m autoextend ON NEXT 32m maxsize 2048m blocksize 8k EXTENT management local;
