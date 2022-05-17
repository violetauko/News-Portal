SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 totalemployees INTEGER
);
CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 generalnews VARCHAR,
 departmentid INTEGER
);
CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 departmentid INTEGER

);
CREATE TABLE IF NOT EXISTS departments_news (
id int PRIMARY KEY auto_increment,
departmentid INTEGER,
newsid INTEGER
);