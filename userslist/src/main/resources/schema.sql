create table student
(
   id integer not null,
   name varchar(255) not null,
   gender varchar(10),
   email varchar(255) not null,
   dept varchar(50),
   cgpa	double,
   placement varchar(25),
   arrears int,
   primary key(id)
);