-- Opgave 1
-- 1: σ postNr=’8230’(Afdeling)
SELECT *
FROM Afdeling
WHERE Afdeling.postNr = '8230';

-- 2: π regNr, ktoNr(Konto)
SELECT Konto.regNr, Konto.ktoNr
FROM Konto;

-- 3: π afdnavn, regNr, ktoNr, saldo(Afdeling ⋈ Konto)
SELECT Afdeling.navn, Afdeling.regNr, Konto.ktoNr, Konto.saldo
FROM Afdeling,
     Konto
WHERE Afdeling.regNr = Konto.ktoNr;

-- 4: π afdnavn, regNr, ktoNr, saldo(σ saldo>10000(Afdeling ⋈ Konto))
SELECT Afdeling.navn, Afdeling.regNr, Konto.ktoNr, Konto.saldo
FROM Afdeling,
     Konto
WHERE Afdeling.regNr = Konto.regNr
  AND Konto.saldo > 10000;

-- 5: π navn, adresse, postNr, bynavn(Kunde ⋈ Postdistrikt)
SELECT Kunde.navn, Kunde.adresse, Kunde.postNr, PostDistrikt.bynavn
FROM Kunde,
     PostDistrikt
WHERE Kunde.postNr = PostDistrikt.postNr;
