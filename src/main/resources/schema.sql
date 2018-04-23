DROP SCHEMA IF EXISTS thinknear;

CREATE SCHEMA thinknear;
USE thinknear;

CREATE TABLE tb_student (
	studentid  INT NOT NULL ,
	firstname  NVARCHAR(50) ,
	lastname   NVARCHAR(50) ,
	PRIMARY KEY(studentid)
);

CREATE TABLE tb_class (
	code        VARCHAR(10) NOT NULL,
	title       VARCHAR(50) ,
	description VARCHAR(50) ,
	PRIMARY KEY (code)
);

CREATE TABLE tb_detail_student_class (
	studentid INT NOT NULL,
	code      VARCHAR(10) NOT NULL,
	PRIMARY KEY (studentid, code)
);