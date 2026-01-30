DROP TABLE IF EXISTS employee_table;

CREATE TABLE employee_table(
    id CHAR(5) NOT NULL,
    password VARCHAR(256) NOT NULL,
    name VARCHAR(256),
    comment VARCHAR(256),
    login_time VARCHAR(19),
    CONSTRAINT pk_employee PRIMARY KEY(id)
);

insert into employee_table(id,password,name,comment) values('09090','admin','yamadatarou','javaman');