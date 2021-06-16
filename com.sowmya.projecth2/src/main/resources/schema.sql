create table student
(
	id integer not null,
	name varchar(100) not null,
	gender varchar(20),
	email varchar(250) not null,
	dept varchar(50),
	cgpa double not null,
	placement varchar(30),
	arrears int,
	primary key(id)
);