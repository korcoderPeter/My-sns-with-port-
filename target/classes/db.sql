create table kim_user(
	username varchar2(14 char) primary key,
	password varchar2(100 char) not null,
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

drop table kim_sns cascade constraint

create table kim_friend(
	summit_user varchar2(14 char) not null,
	status varchar2(10 char) not null,
	accept_user varchar2(14 char) not null,
	constraint connect_summit
	foreign key(summit_user) references kim_user(username)
	on delete cascade,
	constraint connect_accept
	foreign key(accept_user) references kim_user(username)
	on delete cascade
	
	
)

select * from kim_friend where accept_user = 'gldj' and status = 'summit' ;

update KIM_FRIEND
set status = 'accept'
where accept_user = 'gldj' and summit_user = 'gldj98'

select *
from (
select * from KIM_FRIEND where summit_user = 'gldj98' or accept_user = 'gldj98'
)
where status = 'accept'