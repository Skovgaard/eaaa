DROP TABLE Løn;
DROP TABLE Prioritet;
DROP TABLE KontoKunde;
DROP TABLE Transaktion;
DROP TABLE Konto;
DROP TABLE Medarbejder;
DROP TABLE Afdeling;
DROP TABLE Bank;
DROP TABLE Kunde;

CREATE TABLE Bank
(
    navn    CHAR(30) NOT NULL,
    adresse CHAR(30) NOT NULL,
    postNr  INT      NOT NULL,
    byNavn  CHAR(30) NOT NULL,
    PRIMARY KEY (navn)
);

CREATE TABLE Afdeling
(
    regNr   INT      NOT NULL,
    navn    CHAR(30) NOT NULL,
    adresse CHAR(30) NOT NULL,
    postNr  INT      NOT NULL,
    tlfNr   INT      NULL,
    bank    CHAR(30) NOT NULL,
    PRIMARY KEY (regNr),
    FOREIGN KEY (bank) REFERENCES Bank(navn)
);

CREATE TABLE Medarbejder
(
    cprNr   INT      NOT NULL,
    navn    CHAR(30) NOT NULL,
    titel   CHAR(30) NOT NULL,
    adresse CHAR(30) NOT NULL,
    postNr  CHAR(30) NOT NULL,
    byNavn  CHAR(30) NOT NULL,
    regNr   INT      NOT NULL,
    PRIMARY KEY (cprNr),
    FOREIGN KEY (regNr) REFERENCES Afdeling(regNr)
);

CREATE TABLE Konto
(
    regNr       INT     NOT NULL,
    ktoNr       INT     NOT NULL,
    tekst       VARCHAR NULL,
    saldo       INT     NOT NULL,
    renteUdlån  INT     NOT NULL,
    renteIndlån INT     NOT NULL,
    PRIMARY KEY (regNr, ktoNr),
    FOREIGN KEY (regNr) REFERENCES Afdeling
);

CREATE TABLE Kunde
(
    cprNr   INT      NOT NULL,
    navn    CHAR(30) NOT NULL,
    adresse CHAR(30) NOT NULL,
    postNr  INT      NOT NULL,
    byNavn  CHAR(30) NOT NULL,
    PRIMARY KEY (cprNr)
);

CREATE TABLE KontoKunde
(
    regNr INT NOT NULL,
    ktoNr INT NOT NULL,
    cprNr INT NOT NULL,
    PRIMARY KEY (regNr, ktoNr, cprNr),
    FOREIGN KEY (regNr, ktoNr) REFERENCES Konto,
    FOREIGN KEY (cprNr) REFERENCES Kunde
);

CREATE TABLE Transaktion
(
    regNr INT      NOT NULL,
    ktoNr INT      NOT NULL,
    tekst VARCHAR  NULL,
    dato  DATETIME NOT NULL,
    beløb INT      NOT NULL,
    PRIMARY KEY (regNr, ktoNr, dato),
    FOREIGN KEY (regNr, ktoNr) REFERENCES Konto
);

CREATE TABLE Løn
(
    låneret INT NOT NULL,
    regNr   INT NOT NULL,
    ktoNr   INT NOT NULL,
    PRIMARY KEY (regNr, ktoNr),
    FOREIGN KEY (regNr, ktoNr) REFERENCES Konto
);

CREATE TABLE Prioritet
(
    hovedstol INT NOT NULL,
    regNr     INT NOT NULL,
    ktoNr     INT NOT NULL,
    PRIMARY KEY (regNr, ktoNr),
    FOREIGN KEY (regNr, ktoNr) REFERENCES Konto
);

INSERT INTO Bank
    (navn, adresse, postNr, byNavn)
VALUES
    ('Andebybank', 'Andebyvej 1', 1111, 'Andeby');

INSERT INTO Afdeling
    (regNr, navn, adresse, postNr, tlfNr, bank)
VALUES
    (4444, 'Andeby Central Bank', 'Andebyvej 4', 1111, 8888888, 'Andebybank');

INSERT INTO Medarbejder
    (cprNr, navn, titel, adresse, postNr, byNavn, regNr)
VALUES
    (0101010101, 'Anders And', 'Rådgiver', 'Andbyvej 2', 1111, 'Andeby', 4444);

INSERT INTO Konto
    (regNr, ktoNr, tekst, saldo, renteUdlån, renteIndlån)
VALUES
    (4444, 12345678, NULL, 100001, 5, 5);
INSERT INTO Konto
    (regNr, ktoNr, tekst, saldo, renteUdlån, renteIndlån)
VALUES
    (4444, 23456789, NULL, 42, 5, 5);

INSERT INTO Kunde
    (cprNr, navn, adresse, postNr, byNavn)
VALUES
    (0101010101, 'Anders And', 'Andebyvej 2', 1111, 'Andeby');

INSERT INTO Prioritet
    (hovedstol, regNr, ktoNr)
VALUES
    (0, 4444, 12345678);

UPDATE Kunde SET adresse = 'Andebyvej 3' WHERE cprNr = 0101010101;
UPDATE MedArbejder SET adresse = 'Andebyvej 3' WHERE cprNr = 0101010101;