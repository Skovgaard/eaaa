-- 1. Find alle kunder og udskriv deres navn, adresse, postnummer og bynavn.
SELECT Kunde.navn, Kunde.adresse, Kunde.postNr, Kunde.byNavn
FROM Kunde;

-- 2. Find navne på de kunder, der har konto med saldo OVER 12.000 kr.
SELECT Kunde.navn
FROM Kunde, Konto
WHERE Konto.saldo > 12000;

-- Virker ikke?
SELECT Kunde.navn
FROM Kunde, Konto, KontoKunde
WHERE Konto.saldo > 12000 AND Konto.ktoNr = KontoKunde.ktoNr AND Kunde.cprNr = KontoKunde.cprNr;

-- 3. Find navne på de personer, der bor i en bestemt BY (oprettet i systemet).
SELECT Kunde.navn
FROM Kunde
WHERE Kunde.byNavn = 'Andeby';

-- 4. Find de post distrikter, hvor der bor personer, der kar konto med saldo over 100.000kr.
SELECT Kunde.postNr
FROM Kunde, Konto
WHERE Konto.saldo > 100000;

-- 5. Find kontonumre FOR personer, der bor i oprettet i systemet.
SELECT Konto.ktoNr
FROM Konto, Kunde, Medarbejder;

-- 6. Find navne på kunder der har konti i en bestemt afdeling. Vælg selv hvilken afdeling.
SELECT Kunde.navn
FROM Kunde, Konto
WHERE Konto.regNr = 4444;

-- 7. Find navnene og afdeling på alle kunder, der har en prioritetskonto.
SELECT Kunde.navn, Afdeling.navn
FROM Kunde, Afdeling, Prioritet, Konto
WHERE Konto.ktoNr = Prioritet.ktoNr AND Afdeling.regNr = Prioritet.regNr;

SELECT Kunde.navn, Afdeling.navn
FROM Kunde
    INNER JOIN KontoKunde ON KontoKunde.cprNr = Kunde.cprNr
    INNER JOIN Afdeling ON Afdeling.regNr = KontoKunde.regNr
    INNER JOIN Prioritet ON Prioritet.ktoNr = KontoKunde.ktoNr

-- 8. Find navne på de kunder, der har et navn, hvor a indgår
SELECT Kunde.navn
FROM Kunde
WHERE Kunde.navn LIKE '%a%';

-- 9. Find kundeid og navn på de kunder, der har et navn, hvor bogstavet ’a’ indgår eller bor
-- i et postdistrikt, hvor ’r’ indgår.
SELECT Kunde.cprNr, Kunde.navn
FROM Kunde
WHERE Kunde.navn LIKE '%a%' OR kunde.byNavn LIKE '%r%';