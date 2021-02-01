CREATE DATABASE ddba COLLATE Danish_Norwegian_CI_AS
GO
USE ddba
CREATE TABLE personadr
(
    cpr CHAR(10),
    navn VARCHAR(30),
    bynavn VARCHAR(30)
)
CREATE TABLE kontoa
(
    kontonr INT IDENTITY (1001,2),
    kontohavercpr CHAR(10),
    rente INT -- hvis positiv renteindt�gt, negativ renteudgift
)
INSERT INTO personadr
VALUES ('1212921456', 'Ib Hansen', 'Esbjerg')
INSERT INTO personadr
VALUES ('1111971112', 'Per Olsen', 'Kolding')
INSERT INTO personadr
VALUES ('0909950056', 'Jens Andersen', 'Viborg')

INSERT INTO kontoa
VALUES ('1212921456', 1000)
INSERT INTO kontoa
VALUES ('1111971112', 100)
INSERT INTO kontoa
VALUES ('1111971112', -200)
INSERT INTO kontoa
VALUES ('0909950056', 10)
GO
