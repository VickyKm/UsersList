create table student(
  id integer not null,
  name varchar(40) not null,
  gender varchar(20) not null,
  email varchar(45) not null,
  department varchar(20) not null,
  cgpa float not null,
  placement varchar(20) not null,
  arrears integer not null,
  primary key(id)
);