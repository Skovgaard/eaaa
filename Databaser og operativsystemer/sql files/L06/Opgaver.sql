-- Opgave 1
-- 1.1 Lav et VIEW direkte på Kunde tabellen.
CREATE VIEW Kunder
AS
    SELECT *
    FROM Kunde;
GO

-- 1.2 Lav et nyt VIEW på Kunde tabellen – men inkludér også Bynavn fra PostDistrikt tabellen.
CREATE VIEW KunderMedByNavn
AS
    SELECT Kunde.*, PostDistrikt.bynavn
    FROM Kunde,
         PostDistrikt
    WHERE Kunde.postNr = PostDistrikt.postNr;
GO

-- 1.3 Lav et VIEW, der viser alle personer med navn, adresse, postdistrikt, samt kundens konti med den aktuelle saldo.
CREATE VIEW KunderOgKonti
AS
    SELECT Kunde.navn, Kunde.adresse, PostDistrikt.postnr, PostDistrikt.bynavn, Konto.ktoNr, Konto.saldo
    FROM Kunde,
         Konto,
         KundeHarKonto,
         PostDistrikt
    WHERE Kunde.cprNr = KundeHarKonto.cprNr
      AND Konto.ktoNr = KundeHarKonto.ktoNr
      AND Kunde.postNr = Postdistrikt.postNr;
GO

-- 1.4 Lav et VIEW der viser foreningsmængden mellem Kunde og Medarbejder
CREATE VIEW KundeOgMedarbejder
AS
    SELECT Kunde.cprNr, Kunde.navn, Kunde.adresse, Kunde.postNr, Medarbejder.titel
    FROM Kunde
         LEFT JOIN Medarbejder ON Kunde.navn = Medarbejder.navn
    UNION
    SELECT Medarbejder.cprNr, Medarbejder.navn, Medarbejder.adresse, Medarbejder.postNr, Medarbejder.titel
    FROM Medarbejder;
GO

-- Opgave 2
-- 2.1 Lav en stored PROCEDURE, der returnerer kontonummer, saldo, afdelingens registreringsnummer og navn.
CREATE PROCEDURE Konti AS
SELECT Konto.ktoNr, Konto.saldo, Afdeling.regNr, Afdeling.navn AS Afdelingsnavn
FROM Konto,
     Afdeling
WHERE Konto.regNr = Afdeling.regNr;
GO

EXEC Konti

-- 2.2 Lav en stored PROCEDURE, der givet et cpr-nummer, returnerer kontohavers navn, kontonummer og
-- saldo FOR alle den pågældende kontohavers konti.
CREATE PROCEDURE KundesKonti @cprNr CHAR(10) AS
BEGIN
    SELECT Kunde.navn, Konto.ktoNr, Konto.saldo
    FROM Kunde
         INNER JOIN KundeHarKonto ON KundeHarKonto.cprNr = Kunde.cprNr
         INNER JOIN Konto ON Konto.ktoNr = KundeHarKonto.ktoNr
    WHERE Kunde.cprNr = @cprNr
END
GO

EXEC KundesKonti 1209631223

-- 2.3 Lav en stored PROCEDURE, der givet et cpr-nummer, returnerer (i en output-parameter) kontohavers samlede indestående.
CREATE PROCEDURE SamletIndestående @cprNr CHAR(10),
                                   @samlet DECIMAL(20, 2) OUTPUT AS
BEGIN
    SELECT @samlet = sum(Konto.saldo)
    FROM Konto,
         KundeHarKonto
    WHERE KundeHarKonto.ktoNr = Konto.ktoNr
      AND KundeHarKonto.cprNr = @cprNr
END
GO

DECLARE @samlet INT
EXEC SamletIndestående 3112692132, @samlet OUTPUT
SELECT @samlet AS Samlet

-- 2.4 Lav en stored PROCEDURE (med parametre), der kan oprette en ny konto.
CREATE PROCEDURE Opretkonto @regNr INT, @ktoNr INT, @tekst CHAR(20), @saldo REAL, @renteUdlån REAL, @renteIndlån REAL AS
BEGIN
    INSERT INTO Konto (regNr, ktoNr, Tekst, Saldo, Renteindlån, Renteudlån)
    VALUES (@regNr, @ktoNr, @tekst, @saldo, @renteUdlån, @renteIndlån);
END
GO

EXEC OpretKonto 1234, 11115111, 'test konto', 42, 1.2, 5.2


-- Opgave 3
-- Lav en TRIGGER, der forhindrer oprettelsen af en ny konto, hvis den pågældende
-- person allerede har 3 konti i forvejen. Giv en passende fejlmeddelelse.
DROP TRIGGER NyKundeHarKonto;

CREATE TRIGGER NyKundeHarKonto
    ON KundeHarKonto
    AFTER INSERT AS
BEGIN
    DECLARE
        @cprNr AS BIGINT,
        @count AS INT
    SET @cprNr = (SELECT cprNr
                  FROM Inserted),
        @count = (SELECT count(cprNr)
                  FROM KundeHarKonto
                  WHERE cprNr = @cprNr)
END
IF (@count > 3)
    BEGIN
        DELETE FROM KundeHarKonto WHERE ktoNr = (SELECT ktoNr FROM Inserted);
        PRINT 'Kan ikke oprette konti for kunde med 3 i forvejen';
    END
GO

-- Bedre version?
CREATE TRIGGER NyKundeHarKonto
    ON KundeHarKonto
    AFTER INSERT
    AS
BEGIN
    DECLARE
        @cprNr AS BIGINT,
        @count AS INT;

    SELECT @cprNr = cprNr
    FROM Inserted;

    SELECT @count = count(cprNr)
    FROM KundeHarKonto
    WHERE KundeHarKonto.cprNr = @cprNr;

    IF (@count > 3)
        BEGIN
            RAISERROR ('Kan ikke oprette konti for kunde med 3 i forvejen', 16, 10);
            ROLLBACK TRANSACTION
        END
END
GO

-- Endnu bedre
CREATE TRIGGER NyKundeHarKonto
    ON KundeHarKonto
    AFTER INSERT
    AS
    IF (SELECT count(KundeHarKonto.cprNr)
        FROM KundeHarKonto,
             Inserted
        WHERE KundeHarKonto.cprNr = Inserted.cprNr
        GROUP BY KundeHarKonto.cprNr) > 3
        BEGIN
            RAISERROR ('Kan ikke oprette konti for kunde med 3 i forvejen', 16, 10);
            ROLLBACK TRANSACTION
        END
GO

-- skal man også slette kontoen?
-- lidt underlig at lave uden at have en til at lave konto sammen med KundeHarKonto

-- Til at fylde table så vi når op på count = 3
INSERT INTO KundeHarKonto
    (cprNr, regNr, ktoNr)
VALUES ('3112692132', 1234, 1231236);

-- Skal give en fejl, da count = 3
INSERT INTO KundeHarKonto
    (cprNr, regNr, ktoNr)
VALUES ('3112692132', 1234, 1234567);

-- Opgave 4
-- Lav et eller flere Java programmer hvorfra du afprøver views, Stored PROCEDURE og Triggers.
-- Lavet i L06/src/ex4/ex4.java

