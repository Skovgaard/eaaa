DROP TABLE Ordre;
DROP TABLE Kunde;
DROP TABLE Medarb;
DROP TABLE Vare;
DROP TABLE PostDistrikt;

CREATE TABLE PostDistrikt
(
   PostNr INT      NOT NULL,
   Bynavn CHAR(20) NOT NULL,
   PRIMARY KEY (PostNr)
);

CREATE TABLE Vare
(
   VareNr     INT          NOT NULL,
   Emne       CHAR(20)     NOT NULL,
   StkPris    DECIMAL(9,2),
   LagerAntal INT,
   PRIMARY KEY (VareNr)
);

CREATE TABLE Kunde
(
   KundeId CHAR(10) NOT  NULL,
   Navn    CHAR(30) NOT NULL,
   Adresse CHAR(30) NOT NULL,
   PostNr  INT      NOT NULL,
   UNIQUE (Navn, Adresse),
   CONSTRAINT KundeKey PRIMARY KEY (KundeId),
   FOREIGN KEY (PostNr) REFERENCES PostDistrikt
);

CREATE TABLE Medarb
(
   MedarbId CHAR(10) NOT  NULL,
   Navn     CHAR(30) NOT NULL,
   Adresse  CHAR(30) NOT NULL,
   PostNr   INT      NOT NULL,
   UNIQUE (Navn, Adresse),
   PRIMARY KEY (MedarbId),
   FOREIGN KEY (PostNr) REFERENCES PostDistrikt
);

CREATE TABLE Ordre
(
   KundeId   CHAR(10) NOT NULL,
   VareNr    INT      NOT NULL,
   OrdreDato CHAR(10) NOT NULL,
   Antal     INT,
   PRIMARY KEY (KundeId, VareNr, OrdreDato),
   FOREIGN KEY (KundeId) REFERENCES Kunde,
   FOREIGN KEY (VareNr) REFERENCES Vare
);

INSERT INTO PostDistrikt
   (PostNr, Bynavn)
VALUES
   (8230, 'Åbyhøj');

INSERT INTO Kunde
   (KundeId, Navn, Adresse, PostNr)
VALUES
   ('0000000001', 'Ole Olesen', 'Ole Olesens vej 14', 8230);

INSERT INTO Kunde
   (KundeId, Navn, Adresse, PostNr)
VALUES
   ('0000000002', 'Hans Hansen', 'Hans Hansens vej 54', 8230);

INSERT INTO Kunde
   (KundeId, Navn, Adresse, PostNr)
VALUES
   ('0000000004', 'Peter Petersen', 'Peter Petersens vej 44', 8230);

INSERT INTO Medarb
   (MedarbId, Navn, Adresse, PostNr)
VALUES
   ('0000000003', 'Anders And', 'Paradisæblevej 15', 8230);

INSERT INTO Medarb
   (MedarbId, Navn, Adresse, PostNr)
VALUES
   ('0000000002', 'Hans Hansen', 'Hans Hansens vej 54', 8230);


INSERT INTO Vare
   (VareNr, Emne, StkPris, LagerAntal)
VALUES
   (10, 'Harddisk', 370.50, 15);

INSERT INTO Vare
   (VareNr, Emne, StkPris, LagerAntal)
VALUES
   (20, 'Access Point', 456.55, 8);

INSERT INTO Vare
   (VareNr, Emne, StkPris, LagerAntal)
VALUES
   (30, 'Acer Aspire', 4536.00, 3);

INSERT INTO Vare
   (VareNr, Emne, StkPris, LagerAntal)
VALUES
   (40, 'HP Compaq', 6470.50, 8);

INSERT INTO Ordre
   (KundeId, VareNr, OrdreDato, Antal)
VALUES
   ('0000000001', 10, '2009-02-01', 2);

INSERT INTO Ordre
   (KundeId, VareNr, OrdreDato, Antal)
VALUES
   ('0000000001', 20, '2009-02-02', 3);

INSERT INTO Ordre
   (KundeId, VareNr, OrdreDato, Antal)
VALUES
   ('0000000002', 10, '2009-02-02', 2);

INSERT INTO Ordre
   (KundeId, VareNr, OrdreDato, Antal)
VALUES
   ('0000000002', 20, '2009-02-01', 2);

-- Insert/Update
INSERT INTO PostDistrikt
   (PostNr, Bynavn)
VALUES
   (8260, 'Risskov');

UPDATE PostDistrikt
  SET Bynavn = 'Viby J'
  WHERE PostNr = 8260;


-- Insert from another table
INSERT INTO Kunde
   (KundeId, Navn, Adresse, PostNr)
SELECT *
FROM Medarb
WHERE MedarbId = '0000000003';


DELETE FROM Kunde 
WHERE KundeId = '0000000001'
   OR KundeId = '0000000004';
