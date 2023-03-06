use lecture;
insert into dept value ((select max(deptno)+10 from dept AS a ), 'test', 'test');

var a := (select max(deptno)+10 from dept as a);
INSERT INTO dept VALUE (a, 'test', 'test');

create table dept_seq(num INTEGER);
insert into dept_seq values (0); 

update dept_seq set num=num+1;
insert into dept values((select num from dept_seq), 'test', 'test');
