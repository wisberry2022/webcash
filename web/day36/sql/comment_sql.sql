use lecture;



create table bbs36(
   num int primary key,
   sub varchar(50), 
   content text,
   ref int,
   seq int default 0,
   lvl int default 0
);


insert into bbs36 values (1,'test1','test',1,0,0);

insert into bbs36 values (2,'test2','test',2,0,0);

insert into bbs36 values ((select max(num)+1 from bbs36),'test3','test',(select max(num)+1 from bbs36),0,0);

select Auto_increment from information_schema.tables where table_schema = 'lecture' and table_name = 'bbs36';

