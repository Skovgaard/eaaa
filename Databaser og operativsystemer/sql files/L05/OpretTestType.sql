-- Opret en ny tabel TESTTYPE på SQL-serveren. 
-- Tabellen skal indeholde en attribut af hver af følgende typer: 
-- CHAR, VARCHAR, INT, DECIMAL, DATETIME og BIT.
DROP TABLE TestType;

CREATE TABLE TestType
(
    charTest     CHAR(10),
    varcharTest  VARCHAR(10),
    intTest      INT,
    decimalTest  DECIMAL(10,10),
    dateTimeTest DATETIME,
    bitTest      BIT
);