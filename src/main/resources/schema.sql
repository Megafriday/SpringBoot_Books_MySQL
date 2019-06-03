CREATE TABLE IF NOT EXISTS baseball.books (
	id int primary key auto_increment,
	title varchar(255),
	author varchar(255),
	publish_date date,
	price int
);
