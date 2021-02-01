-- Opgave 1
-- Kig på tabeldefinitionerne i de to scripts. Find ud af hvilke typer fragmentering,
-- der er tale om og lav rekonstruktionen.

-- Person er vertikal og konto er horisontal

-- Lav til slut det globale skema ved at lave to views person og konto.
-- Du afgør selv i hvilken database de to views skal laves.
-- Man tilgår en tabel mintabel i en anden database andendb ved at kalde den 'andendb.dbo.mintabel'

CREATE VIEW Person
AS
    SELECT personadr.cpr, navn, bynavn, ddbb.loen, ddbb.skatteprocent
    FROM personadr
         LEFT JOIN ddbb.dbo.personloen ddbb ON personadr.cpr = ddbb.cpr


CREATE VIEW Konto
AS
    SELECT *
    FROM kontoa
    UNION
    SELECT *
    FROM ddbb.dbo.kontob

-- Brug de pågældende views til lave en query, der viser en persons navn
-- og hvor meget den pågældende skal betale i skat af den pågældendes samlede renteindtægter.

-- løn * renteindtægt * skatteprocent

SELECT navn, loen * (max(rente) / 100) * skatteprocent / 100 AS skat
FROM person
     JOIN konto ON person.cpr = konto.kontohavercpr
GROUP BY navn, loen, skatteprocent

-- Lav på person-viewet en instead of trigger til insert af en ny person.
-- Triggeren skal indsætte data i de to tabeller personadr og personloen.

CREATE TRIGGER nyperson
    ON person
    INSTEAD OF INSERT
    AS
BEGIN
    INSERT INTO personadr(cpr, navn, bynavn)
    SELECT cpr, navn, bynavn
    FROM inserted
    INSERT INTO ddbb.dbo.personloen(cpr, loen, skatteprocent)
    SELECT cpr, loen, skatteprocent
    FROM inserted
END

INSERT INTO person
VALUES ('cpr', 'navn', 'bynavn', 100, 10)

