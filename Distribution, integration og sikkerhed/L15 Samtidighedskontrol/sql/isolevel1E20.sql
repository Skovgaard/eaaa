use eksempeldb
set transaction isolation level read uncommitted
set transaction isolation level read committed
set transaction isolation level repeatable read 
set transaction isolation level serializable

-- dirty read
--1
begin tran
insert into person values('19','hans kurt','systemudvikler',400000,'8210')
--3
rollback tran

-- unrepeatable read (lost update) 
-- 2
begin tran
update person set loen = loen*1.02 where cpr = '1212121212' 
commit tran

-- phantom 

-- 2
insert into person values('23','hans kurt3','systemudvikler',4000000,'8220')

-- 2
select sum(loen) from person
