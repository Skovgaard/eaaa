-- 1. find alle kunder i en bestemt afdeling med en saldo over 50000
SELECT
    K.*
FROM
    Kunde K
    INNER JOIN KundeHarKonto KK ON K.cprNr = KK.cprNr
    INNER JOIN Konto KO ON KO.regNr = KK.regNr AND KO.ktoNr = KK.ktonr
WHERE saldo > 50000;

-- 2. Find alle transaktioner fra den ‘2008 - 08-03’ til den ‘2008-08-06’ til en konto hvor ejeren bor i postnummeret ‘1313’
SELECT
    T.*
FROM
    Transaktion T
    INNER JOIN Konto K ON T.regNr = K.regNr
    INNER JOIN KundeHarKonto KK ON KK.ktonr = K.ktoNr
    INNER JOIN Kunde KU ON KK.cprNr = KU.cprNr
WHERE KU.postNr = 1313 AND T.dato BETWEEN '2008-08-03' AND '2008-08-06';

-- 3. find alle der har låneret ud fra en bestemt afdeling
SELECT
    K.*,
    A.navn AS afdelingsnavn
FROM
    Kunde K
    INNER JOIN KundeHarKonto KK ON KK.cprNr = K.cprNr
    INNER JOIN Afdeling A ON A.regNr = KK.regNr
    INNER JOIN Løn L ON L.regNr = KK.regNr AND L.ktoNr = KK.ktoNr
WHERE A.regNr = 1234;


SELECT
    Kunde.navn AS KundeNavn,
    Løn.låneret,
    Afdeling.navn AS AfdelingsNavn
FROM
    Kunde,
    Løn
    INNER JOIN Afdeling ON Afdeling.regNr = Løn.regNr
    INNER JOIN Konto ON Konto.ktoNr = Løn.ktoNr
    INNER JOIN KundeHarKonto ON KundeHarKonto.ktonr = Konto.ktoNr
WHERE Kunde.cprNr = KundeHarKonto.cprNr;