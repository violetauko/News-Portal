## News Api

## Description
This is a REST Api for querying and retrieving news and information for an organization.

## Author
Violet Auko

## How it is used 
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

## End points
#### Create new department
Post /departments/new

#### Get all departments
get /departments

#### Get department by id
get /departments/:id

#### Create new user
Post /users/new

#### Get all users
get /users

#### Get users by id
get /users/:id

#### Create new news
Post /news/new

#### Get all news
get /news

#### Get news by id
get /news/:id

## Technologies Used
1.Java

2.Postgres

## License
MIT