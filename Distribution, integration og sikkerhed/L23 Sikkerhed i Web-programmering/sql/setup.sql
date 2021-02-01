-- script til DB
create DATABASE tempdb

-- table placeres i tempdb
use tempdb
create table brugere
(brugerid char(10),
 passw char(8)
)
insert into brugere values('kaj','haj')
insert into brugere values('karsten','skak')

-- Denne stump kører du bare fra Management Studio.
use master
EXECUTE sp_configure 'show advanced options', 1 RECONFIGURE WITH OVERRIDE
GO
EXECUTE sp_configure 'xp_cmdshell', '1' RECONFIGURE WITH OVERRIDE
GO
EXECUTE sp_configure 'show advanced options', 0 RECONFIGURE WITH OVERRIDE