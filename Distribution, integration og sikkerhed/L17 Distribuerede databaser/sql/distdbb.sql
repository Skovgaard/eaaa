CREATE DATABASE ddbb COLLATE Danish_Norwegian_CI_AS
GO
USE ddbb
CREATE TABLE personloen
(
    cpr CHAR(10)
        PRIMARY KEY,
    loen INT,
    skatteprocent INT
)

CREATE TABLE kontob
(
    kontonr INT
        PRIMARY KEY IDENTITY (1002,2),
    kontohavercpr CHAR(10),
    rente INT -- hvis positiv renteindt�gt, negativ renteudgift
)
INSERT INTO personloen
VALUES ('1212921456', 307000, 39)
INSERT INTO personloen
VALUES ('1111971112', 500000, 41)
INSERT INTO personloen
VALUES ('0909950056', 200000, 38)

INSERT INTO kontob
VALUES ('1212921456', 654)
INSERT INTO kontob
VALUES ('1212921456', -63)
INSERT INTO kontob
VALUES ('1111971112', 87)