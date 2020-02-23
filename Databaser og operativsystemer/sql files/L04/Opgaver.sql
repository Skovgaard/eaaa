-- 1. Find gennemsnits saldo pr. afdeling
SELECT AVG(Konto.saldo) AS GennemsnitSaldo, Konto.regNr
FROM Konto
GROUP BY Konto.regNr;

-- 2. Find gennemsnits saldo pr. afdeling for kunder med en lønkonto
SELECT AVG(Konto.saldo) AS GennemsnitSaldo, Konto.regNr
FROM Konto,
     Løn
WHERE Konto.ktoNr = Løn.ktoNr
  AND Konto.regNr = Løn.regNr
GROUP BY Konto.regNr;

SELECT AVG(Konto.saldo) AS GennemsnitSaldo, Konto.regNr
FROM Konto
         INNER JOIN Løn ON Konto.ktoNr = Løn.ktoNr AND Konto.regNr = Løn.regNr
GROUP BY Konto.regNr;

-- 3. Find antal kunder pr. afdeling
SELECT COUNT(KundeHarKonto.cprNr) AS AntalKontoer, Afdeling.navn
FROM KundeHarKonto,
     Afdeling
WHERE KundeHarKonto.regNr = Afdeling.regNr
GROUP BY Afdeling.navn;

-- 4. Find de kunder, der ikke har en lønkonto
SELECT Kunde.*
FROM Kunde
         INNER JOIN KundeHarKonto ON KundeHarKonto.cprNr = Kunde.cprNr
WHERE KundeHarKonto.ktoNr NOT IN (SELECT Løn.ktoNr
                                  FROM Løn)

-- 5. Find de postnumre, hvor der hverken bor kunder eller medarbejdere
SELECT PostDistrikt.postNr
FROM PostDistrikt
    EXCEPT
SELECT Kunde.postNr
FROM Kunde
    EXCEPT
SELECT Medarbejder.postNr
FROM Medarbejder;

SELECT PostDistrikt.postNr
FROM PostDistrikt
WHERE PostDistrikt.postNr NOT IN (
    SELECT Kunde.postNr
    FROM Kunde
    UNION
    SELECT Medarbejder.postNr
    FROM Medarbejder);


-- 6. Find navn, kontonummer transaktionstekst og transaktionsbeløb FOR en given kunde.
-- (sorteret efter transaktionsdato)
SELECT Kunde.navn, Konto.ktoNr, Transaktion.tekst, Transaktion.beløb
FROM Kunde
         INNER JOIN KundeHarKonto ON KundeHarKonto.cprNr = Kunde.cprNr
         INNER JOIN Konto ON Konto.ktoNr = KundeHarKonto.ktonr
         INNER JOIN Transaktion ON Transaktion.ktoNr = Konto.ktoNr
WHERE Kunde.cprNr = 3112692132
ORDER BY Transaktion.dato;

-- 7. For alle prioritetskonti ønskes forskellen på saldo og hoved stol beregnet.
SELECT Prioritet.ktoNr, Prioritet.hovedstol - Konto.saldo AS Forskel
FROM Prioritet,
     Konto
WHERE Prioritet.ktoNr = Konto.ktoNr

SELECT Prioritet.ktoNr, Prioritet.hovedstol - Konto.saldo AS Forskel
FROM Prioritet
         INNER JOIN Konto ON Konto.ktoNr = Prioritet.ktoNr;

-- 8. Find de konti, der ikke har transaktioner.
SELECT Konto.ktoNr
FROM Konto
    EXCEPT
SELECT Transaktion.ktoNr
FROM Transaktion;

SELECT Konto.*
FROM Konto
WHERE Konto.ktoNr NOT IN (SELECT Transaktion.ktoNr
                          FROM Transaktion);
