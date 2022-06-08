create table kim_user(
	username varchar2(14 char) primary key,
	password varchar2(14 char) not null,
	name varchar2(10 char) not null,
	userbirth varchar2(30 char) not null,
	address varchar2(30 char) not null,
	email varchar2 (30 char) not null,
	phonenumber varchar2 (30 char) not null
);