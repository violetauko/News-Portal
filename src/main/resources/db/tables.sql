CREATE DATABASE news_api;
\c news_api;

CREATE TABLE departments (
 id SERIAL PRIMARY KEY ,
 name VARCHAR,
 description VARCHAR,
 totalemployees INTEGER
);
CREATE TABLE  news (
 id SERIAL PRIMARY KEY ,
 generalnews VARCHAR,
 departmentid INTEGER
);
CREATE TABLE users (
 id SERIAL PRIMARY KEY ,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 departmentid INTEGER

);
CREATE TABLE  departments_news (
id SERIAL PRIMARY KEY ,
departmentid INTEGER,
newsid INTEGER
);