drop DATABASE bankdb;
create DATABASE bankdb;

create table bankkunde
(
cpr char(10) primary key,
navn varchar(50)
)

create table konto
(
kontonr int primary key,
saldo int,
kunde char(10) foreign key references bankkunde
)
insert into bankkunde values('12','Hansen')
insert into bankkunde values('13','Jensen')
insert into bankkunde values('14','Pedersen')
insert into bankkunde values('15','Ibsen')
insert into konto values(1001,100,'12')
insert into konto values(1002,1000,'12')
insert into konto values(1003,10000,'13')
insert into konto values(1004,100000,'14')