create table userinfo(
	num int unique not null auto_increment,
	id varchar(35) primary key,
	pwd varchar(50) not null,
	re varchar(50) not null,
	name varchar(30) not null,
	email varchar(60) unique null
);

