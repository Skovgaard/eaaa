-- Mathias
USE [master]
GO
EXEC sp_addlinkedserver
     @server='10.24.2.53',
     @srvproduct='SQL Server'
GO

EXEC sp_addlinkedsrvlogin
     @rmtsrvname = '10.24.2.53',
     @useself = 'false',
     @locallogin = 'sa',
     @rmtuser = 'sa',
     @rmtpassword = 'mfafoldager17'
GO

EXEC sp_dropserver
     @server='10.24.2.53',
     @droplogins = 'droplogins'
GO

SELECT *
FROM [10.24.2.53].ddba.dbo.kontoa

