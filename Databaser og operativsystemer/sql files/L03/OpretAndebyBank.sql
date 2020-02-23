DROP TABLE Løn;
DROP TABLE Prioritet;
DROP TABLE Transaktion;
DROP TABLE Konto;
DROP TABLE KontoHistorik;
DROP TABLE KundeHarKontoHistorik;
DROP TABLE KundeHarKonto;
DROP TABLE Kunde;
DROP TABLE KundeHistorik;
DROP TABLE Medarbejder;
DROP TABLE Afdeling;
DROP TABLE Bank;
DROP TABLE PostDistrikt;


CREATE TABLE PostDistrikt
(
  postNr INT,
  bynavn CHAR(20),
  PRIMARY KEY (postNr)
);

CREATE TABLE Bank
(
  navn    CHAR(30),
  adresse CHAR(30),
  postNr  INT,
  FOREIGN KEY (postNr) REFERENCES PostDistrikt (postNr)
);

CREATE TABLE Afdeling
(
  regNr   INT,
  navn    CHAR(20),
  adresse CHAR(30),
  postNr  INT,
  tlfNr   CHAR(11),
  PRIMARY KEY (regNr),
  FOREIGN KEY (postNr) REFERENCES PostDistrikt (postNr)
);

CREATE TABLE Medarbejder
(
  cprNr    CHAR(10),
  afdeling INT,
  titel    CHAR(20),
  navn     CHAR(30),
  adresse  CHAR(30),
  postNr   INT,
  PRIMARY KEY (cprNr),
  FOREIGN KEY (postNr) REFERENCES PostDistrikt (postNr),
  FOREIGN KEY (afdeling) REFERENCES Afdeling (regNr)
);

CREATE TABLE Kunde
(
  cprNr   CHAR(10),
  navn    CHAR(30),
  adresse CHAR(30),
  postNr  INT,
  PRIMARY KEY (cprNr),
  FOREIGN KEY (postNr) REFERENCES PostDistrikt (postNr)
);

CREATE TABLE KundeHarKonto
(
  cprNr CHAR(10),
  regNr INT,
  ktonr BIGINT
);

CREATE TABLE Konto
(
  regNr       INT,
  ktoNr       BIGINT,
  tekst       CHAR(20),
  saldo       REAL,
  renteIndlån REAL,
  renteUdlån  REAL,
  PRIMARY KEY (regNr, ktoNr),
  FOREIGN KEY (regNr) REFERENCES Afdeling (regNr)
);

CREATE TABLE Transaktion
(
  regNr INT,
  ktoNr BIGINT,
  dato  CHAR(10),
  tekst CHAR(20),
  beløb REAL,
  FOREIGN KEY (regNr, ktoNr) REFERENCES Konto  (regNr, ktoNr)
);

CREATE TABLE Løn
(
  regNr   INT,
  ktoNr   BIGINT,
  låneret REAL,
  PRIMARY KEY (regNr, ktoNr),
  FOREIGN KEY (regNr, ktoNr) REFERENCES Konto (regNr, ktoNr)
);

CREATE TABLE Prioritet
(
  regNr     INT,
  ktoNr     BIGINT,
  hovedstol REAL,
  PRIMARY KEY (regNr, ktoNr),
  FOREIGN KEY (regNr, ktoNr) REFERENCES Konto (regNr, ktoNr)
);





INSERT INTO PostDistrikt
  (postNr, bynavn)
VALUES
  ( 1313, 'Andeby');
INSERT INTO PostDistrikt
  (postNr, bynavn)
VALUES
  ( 9191, 'Gåseråd');
INSERT INTO PostDistrikt
  (postNr, bynavn)
VALUES
  ( 3456, 'Griseløse');

INSERT INTO Bank
  (navn, adresse, postNr)
VALUES
  ( 'Andeby Bank A/S', 'Joakim von And Boulevarden 4', 1313);

INSERT INTO Afdeling
  (regNr, navn, adresse, postNr, tlfNr)
VALUES
  ( 1234, 'Andeby Nygade', 'Andeby Nygade 21', 1313, '+4589135689');
INSERT INTO Afdeling
  (regNr, navn, adresse, postNr, tlfNr)
VALUES
  ( 1216, 'Gåseråd', 'Gåseråd Bygade 14', 9191, '+4589121241');
INSERT INTO Afdeling
  (regNr, navn, adresse, postNr, tlfNr)
VALUES
  ( 1220, 'Griseløse', 'Gammel Torv 2', 3456, '+4589421212');

INSERT INTO Medarbejder
  (cprNr, afdeling, titel, navn, adresse, postNr)
VALUES
  ( '1209631223', 1234, 'Afdelingsdirektør', 'Mickie Mouse', 'Spidsmusehegnet 1', 1313);
INSERT INTO Medarbejder
  (cprNr, afdeling, titel, navn, adresse, postNr)
VALUES
  ( '2210711443', 1234, 'Erhvervsrådgiver', 'Fedtmule', 'Spidsmusehegnet 3', 1313);
INSERT INTO Medarbejder
  (cprNr, afdeling, titel, navn, adresse, postNr)
VALUES
  ( '3112692132', 1234, 'Erhvervsrådgiver', 'Minnie Mouse', 'Andeby Nygade 11', 1313);
INSERT INTO Medarbejder
  (cprNr, afdeling, titel, navn, adresse, postNr)
VALUES
  ( '1504788775', 1234, 'Privatrådgiver', 'Sorteper', 'Forbrydervænget 9', 1313);
INSERT INTO Medarbejder
  (cprNr, afdeling, titel, navn, adresse, postNr)
VALUES
  ( '2712598753', 1216, 'Privatrådgiver', 'Fætter Guf', 'Bondegården 3', 9191);

INSERT INTO Kunde
  (cprNr, navn, adresse, postNr)
VALUES
  ( '1209631223', 'Store Stygge Ulv', 'Skovkanten 1', 3456);
INSERT INTO Kunde
  (cprNr, navn, adresse, postNr)
VALUES
  ( '2210711443', 'Lille Stygge Ulv', 'Skovkanten 1', 3456);
INSERT INTO Kunde
  (cprNr, navn, adresse, postNr)
VALUES
  ( '3112692132', 'De tre små grise', 'Skovkanten 7', 3456);
INSERT INTO Kunde
  (cprNr, navn, adresse, postNr)
VALUES
  ( '1504788758', 'Andersine', 'Andeby Nygade 57', 1313);
INSERT INTO Kunde
  (cprNr, navn, adresse, postNr)
VALUES
  ( '2712598723', 'Anders And', 'Paradisæblevej 13', 1313);

INSERT INTO Konto
  (regNr, ktoNr, tekst, saldo, renteIndlån, renteUdlån)
VALUES
  ( 1234, 1234567, 'Lønkonto', 10000.00, 1.2, 5.2);
INSERT INTO Konto
  (regNr, ktoNr, tekst, saldo, renteIndlån, renteUdlån)
VALUES
  ( 1234, 1231236, 'Lønkonto', 5000.00, 1.2, 5.2);
INSERT INTO Konto
  (regNr, ktoNr, tekst, saldo, renteIndlån, renteUdlån)
VALUES
  ( 1234, 1357967, 'Lønkonto', 12000.00, 1.2, 5.2);
INSERT INTO Konto
  (regNr, ktoNr, tekst, saldo, renteIndlån, renteUdlån)
VALUES
  ( 1216, 1256788, 'Lønkonto', 15000.00, 1.2, 5.2);
INSERT INTO Konto
  (regNr, ktoNr, tekst, saldo, renteIndlån, renteUdlån)
VALUES
  ( 1216, 2234567, 'Boliglån', 2550000.00, 1.2, 5.2);
INSERT INTO Konto
  (regNr, ktoNr, tekst, saldo, renteIndlån, renteUdlån)
VALUES
  ( 1234, 2231236, 'Boliglån', 3175000.00, 1.2, 5.2);

INSERT INTO KundeHarKonto
  (cprNr, regNr, ktonr)
VALUES
  ( '1209631223', 1234, 2231236 );
INSERT INTO KundeHarKonto
  (cprNr, regNr, ktonr)
VALUES
  ( '2210711443', 1234, 2231236 );
INSERT INTO KundeHarKonto
  (cprNr, regNr, ktonr)
VALUES
  ( '3112692132', 1216, 1256788 );
INSERT INTO KundeHarKonto
  (cprNr, regNr, ktonr)
VALUES
  ( '3112692132', 1234, 1357967 );

INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 2231236, '2008-01-02', 'Indbetaling', 5000.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 2231236, '2008-04-01', 'Indbetaling', 25000.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 2231236, '2008-08-03', 'Udbetaling', 500.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-04', 'Uddbetaling', 1000.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-05', 'Uddbetaling', 50.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-06', 'Uddbetaling', 250.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-07', 'Uddbetaling', 1250.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-08', 'Uddbetaling', 255.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-10', 'Uddbetaling', 300.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-11', 'Uddbetaling', 410.00);
INSERT INTO Transaktion
  (regNr, ktoNr, dato, tekst, beløb)
VALUES
  ( 1234, 1357967, '2008-08-12', 'Udbetaling', 50.00);

INSERT INTO Løn
  (regNr, ktoNr, låneret)
VALUES
  ( 1234, 1234567, 10000.00);
INSERT INTO Løn
  (regNr, ktoNr, låneret)
VALUES
  ( 1234, 1231236, 5000.00);
INSERT INTO Løn
  (regNr, ktoNr, låneret)
VALUES
  ( 1234, 1357967, 12000.00);
INSERT INTO Løn
  (regNr, ktoNr, låneret)
VALUES
  ( 1216, 1256788, 15000.00);

INSERT INTO Prioritet
  (regNr, ktoNr, hovedstol)
VALUES
  ( 1216, 2234567, 5550000.00);
INSERT INTO Prioritet
  (regNr, ktoNr, hovedstol)
VALUES
  ( 1234, 2231236, 4500000.00);
