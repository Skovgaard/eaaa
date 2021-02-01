-- OPGAVE 4
-- Du skal rette dine views fra opgave 1 så de virker, hvor du bruger din egen database A
-- og din makkers database B eller omvendt.
-- Instead of triggeren vil dog ikke virke før du har lavet opgave 5.
-- Ret også i Java-programmerne i opgave 2, så de også virker til distribuerede queries.

-- [10.24.2.53].ddba.dbo.kontoa

CREATE VIEW PersonLinked
AS
    SELECT personadr.cpr, navn, bynavn, ddbb.loen, ddbb.skatteprocent
    FROM personadr
         INNER JOIN [10.24.2.53].ddbb.dbo.personloen ddbb ON personadr.cpr = ddbb.cpr
GO

CREATE VIEW KontoLinked
AS
    SELECT *
    FROM kontoa
    UNION
    SELECT *
    FROM [10.24.2.53].ddbb.dbo.kontob