-- 1. find alle kunder i en bestemt afdeling med en saldo OVER 50000
-- 2. Find alle transaktioner fra den ‘2008 - 08-03’ til den ‘2008-08-06’ til en konto hvor ejeren bor i postnummeret ‘1313’
SELECT T.*
FROM Transaktion T


-- 3. find alle der har låneret ud fra en bestemt afdeling
SELECT Kunde.navn AS KundeNavn, Løn.låneret, Afdeling.navn AS AfdelingsNavn
FROM Kunde, Løn
    INNER JOIN Afdeling ON Afdeling.regNr = Løn.regNr
    INNER JOIN Konto ON Konto.ktoNr = Løn.ktoNr
    INNER JOIN KundeHarKonto ON KundeHarKonto.ktonr = Konto.ktoNr
WHERE Kunde.cprNr = KundeHarKonto.cprNr;