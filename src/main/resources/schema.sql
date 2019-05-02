CREATE TABLE IF NOT EXISTS baseball.books (
	id varchar(255) primary key,
	title varchar(255),
	author varchar(255),
	publish_date date,
	price integer
);
