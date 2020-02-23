drop table Test;

create table Test
(
    TestNr int not null,
    TestNavn char(20) not null,
    primary key (TestNr)
);

insert into Test
    (TestNr, TestNavn)
values
    (1, 'testA');

insert into Test
    (TestNr, TestNavn)
values
    (2, 'testB');

