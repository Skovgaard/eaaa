drop table Ordre;
drop table Kunde;
drop table Medarb;
drop table Vare;
drop table PostDistrikt;

create table PostDistrikt (
  PostNr int not null,
  Bynavn char(20) not null,
  primary key (PostNr));

create table Vare (
  VareNr int not null,
  Emne char(20) not null,
  StkPris decimal(9,2),
  LagerAntal int,
  primary key (VareNr));

create table Kunde  (
  KundeId char(10) not  null,
  Navn    char(30) not null,
  Adresse char(30) not null,
  PostNr  int not null,
  unique (Navn, Adresse),
  constraint KundeKey primary key (KundeId),
  foreign key (PostNr) references PostDistrikt );

create table Medarb  (
  MedarbId char(10) not  null,
  Navn    char(30) not null,
  Adresse char(30) not null,
  PostNr  int not null,
  unique (Navn, Adresse),
  primary key (MedarbId),
  foreign key (PostNr) references PostDistrikt );

create table Ordre (
  KundeId char(10) not null,
  VareNr int not null,
  OrdreDato char(10) not null,
  Antal int,
  primary key (KundeId, VareNr, OrdreDato),
  foreign key (KundeId) references Kunde,
  foreign key (VareNr) references Vare );

insert into PostDistrikt
   (PostNr, Bynavn)
values (8230, 'Åbyhøj');

insert into Kunde
   (KundeId, Navn, Adresse, PostNr)
values ('0000000001', 'Ole Olesen', 'Ole Olesens vej 14', 8230);

insert into Kunde
   (KundeId, Navn, Adresse, PostNr)
values ('0000000002', 'Hans Hansen', 'Hans Hansens vej 54', 8230); 

insert into Kunde
(KundeId, Navn, Adresse, PostNr)
values ('0000000004', 'Peter Petersen', 'Peter Petersens vej 44', 8230);

insert into Medarb
   (MedarbId, Navn, Adresse, PostNr)
values ('0000000003', 'Anders And', 'Paradisæblevej 15', 8230);

insert into Medarb
   (MedarbId, Navn, Adresse, PostNr)
values ('0000000002', 'Hans Hansen', 'Hans Hansens vej 54', 8230);

insert into Vare
   (VareNr, Emne, StkPris, LagerAntal)
values (10, 'Harddisk', 370.50, 15);

insert into Vare
   (VareNr, Emne, StkPris, LagerAntal)
values (20, 'Access Point', 456.55, 8);

insert into Vare
   (VareNr, Emne, StkPris, LagerAntal)
values (30, 'Acer Aspire', 4536.00, 3);

insert into Vare
   (VareNr, Emne, StkPris, LagerAntal)
values (40, 'HP Compaq', 6470.50, 8);

insert into Ordre
   (KundeId, VareNr, OrdreDato, Antal)
values ('0000000001', 10, '2009-02-01', 2);

insert into Ordre
   (KundeId, VareNr, OrdreDato, Antal)
values ('0000000001', 20, '2009-02-02', 3);

insert into Ordre
   (KundeId, VareNr, OrdreDato, Antal)
values ('0000000002', 10, '2009-02-02', 2);

insert into Ordre
   (KundeId, VareNr, OrdreDato, Antal)
values ('0000000002', 20, '2009-02-01', 2);

insert into PostDistrikt
   (PostNr, Bynavn)
values (8260, 'Risskov');

update PostDistrikt set Bynavn = 'Viby J' where PostNr = 8260;