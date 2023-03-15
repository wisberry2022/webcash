### nodejs & Express & mysql

#### mysql docker setting
```
+++cmd+++
docker run -it --rm -d -p 3306:3306 ^
 -e MYSQL_ROOT_PASSWORD=mysql ^
 -e MYSQL_USER=scott ^
 -e MYSQL_PASSWORD=tiger ^
 -e MYSQL_DATABASE=lecture ^
 --network group1 ^
 --name mysql8 ^
 -v mysqlData:/var/lib/mysql mysql 


>docker exec -it 79 /bin/bash

+++bash+++
>mysql -u root -pmysql

+++mysql+++
>alter user 'scott'@'%' identified with mysql_native_password by 'tiger';
>grant all privileges on *.* TO 'scott'@'%';
>flush privileges;
>use mysql;
>select host, user, authentication_string from user;

```