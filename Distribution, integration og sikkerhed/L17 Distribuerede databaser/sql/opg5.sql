EXEC sp_sqljdbc_xa_install

USE master;
        sp_grantdbaccess 'myuser', 'myuser';
EXEC sp_addrolemember [SqlJDBCXAUser], 'myuser'