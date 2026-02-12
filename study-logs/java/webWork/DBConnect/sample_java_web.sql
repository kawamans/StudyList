CREATE DATABASE sample_java_web;
USE sample_java_web;

CREATE TABLE
dictionary
(
    engword varchar(50) NOT NULL,
    jpword varchar(50) NOT NULL,
    UNIQUE (engword, jpword)
) DEFAULT CHARSET=utf8mb4;

INSERT INTO dictionary VALUES ('apple', 'りんご');
INSERT INTO dictionary VALUES ('orange', 'みかん');
