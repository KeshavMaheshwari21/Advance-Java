
Java cmd :-
set classpath="%classpath%;C:\Program Files (x86)\Java\jdk1.8.0_11\bin\mysql-connector.jar;.;"

Mysql cmd :-
mysql -u root -p
password : root
use test;
 create table emp(
    -> id int,
    -> name varchar(20),
    -> address varchar(20));
insert into emp values(1,"manvik","Jaipur");
