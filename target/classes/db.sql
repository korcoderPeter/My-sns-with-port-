create table kim_user(
	username varchar2(14 char) primary key,
	password varchar2(14 char) not null,
	name varchar2(10 char) not null,
	userbirth varchar2(30 char) not null,
	address varchar2(30 char) not null,
	email varchar2 (30 char) not null,
	phonenumber varchar2 (30 char) not null
);

create table kim_sns(
	sns_no number(4) primary key,
	writer varchar2(14 char) not null,
	title varchar2(50 char) not null,
	content varchar2(1000 char) not null,
	when date not null,
	constraint sns_content
	foreign key(writer) references kim_user(username)
	on delete cascade
	
);

create sequence kim_sns_seq;

