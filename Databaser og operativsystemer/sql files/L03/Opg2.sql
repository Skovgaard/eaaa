-- 1. Skriv et antal queries således at du får udskrevet indholdet fra hver af tabellerne i det lille ordresystem.
SELECT *
FROM Kunde;

SELECT *
FROM Medarb;

SELECT *
FROM Ordre;

SELECT *
FROM PostDistrikt;

SELECT *
FROM Vare;

-- 2. Skriv en query der joiner Kunde og Ordre tabellerne og udskriver alle data i de to tabeller .
SELECT *
FROM Kunde, Ordre
WHERE kunde.KundeId = ordre.KundeId;


-- 3. Skriv en query der udskriver kundenavn, varenummer og antal for ordre hvor ordredato er 1. februar 2009.
SELECT Kunde.Navn, Vare.VareNr, Ordre.Antal
FROM Kunde, Vare, Ordre
WHERE Ordre.OrdreDato = '2009-02-01' AND Kunde.KundeId = Ordre.KundeId AND Vare.VareNr = Ordre.VareNr;

-- 4. Skriv en query der udskriver kundeid, kundenavn, postnummer, bynavn, varenummer, emne og ordreantal FOR ordre hvor ordredato er 2. februar 2009.
SELECT Kunde.KundeId, Kunde.Navn, Kunde.PostNr, PostDistrikt.Bynavn, Vare.VareNr, Vare.Emne, Ordre.Antal
FROM Kunde, PostDistrikt, Vare, Ordre
WHERE Ordre.OrdreDato = '2009-02-01' AND Kunde.PostNr = PostDistrikt.PostNr AND Kunde.KundeId = Ordre.KundeId AND Ordre.VareNr = Vare.VareNr;

-- 5. Skriv en query hvor du udskriver de kunder der også er medarbejdere.
SELECT Kunde.*
FROM Kunde, Medarb
WHERE Kunde.KundeId = Medarb.MedarbId;

-- 6. Skriv en query hvor du udskriver både medarbejdere og kunder
    SELECT *
    FROM Kunde
INTERSECT
    SELECT *
    FROM Medarb

-- 7. Skriv en query hvor du udskriver de kunder der ikke også er medarbejdere
SELECT Kunde.*
FROM Kunde
WHERE Kunde.Navn NOT IN (SELECT Medarb.Navn
FROM Medarb);

    SELECT Kunde.*
    FROM Kunde
EXCEPT
    SELECT *
    FROM Medarb