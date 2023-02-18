create table roomType (
	typenum tinyint primary key,
	roomtype varchar(15) not null,
	roomname varchar(40) unique not null,
	maxnum tinyint not null,
	price int not null
);

insert into roomType values(1, "single", "daisy", 1, 35000);
insert into roomType values(2, "twin", "rose", 2, 55000);
insert into roomType values(3, "triple","fancy", 3, 85000);
insert into roomType values(4, "family","ruby", 6, 160000);
insert into roomType values(5, "grand", "oblibion", 10, 350000);


create table room (
	typenum tinyint not null,
	num int primary key,
	foreign key (typenum) references roomType(typenum)
);

insert into room values(1, 101);
insert into room values(1, 102);
insert into room values(1, 103);
insert into room values(1, 104);
insert into room values(1, 105);
insert into room values(2, 201);
insert into room values(2, 202);
insert into room values(2, 203);
insert into room values(2, 204);
insert into room values(2, 205);
insert into room values(3, 301);
insert into room values(3, 302);
insert into room values(3, 303);
insert into room values(3, 304);
insert into room values(3, 305);
insert into room values(4, 401);
insert into room values(4, 402);
insert into room values(4, 403);
insert into room values(4, 404);
insert into room values(4, 405);
insert into room values(5, 501);
insert into room values(5, 502);
insert into room values(5, 503);
insert into room values(5, 504);
insert into room values(5, 505);



