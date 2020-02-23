package ex4;

import databaseconnection.ConnectionUrl;
import resultsetprinter.ResultSetPrinter;

import java.sql.*;

public class ex4 {

    public static void main(String[] args) {
        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            // Opg4: Lav et eller flere Java programmer hvorfra du afprøver views, Stored PROCEDURE og Triggers.
            System.out.println("Opgave 4: Lav et eller flere Java programmer hvorfra du afprøver views, Stored PROCEDURE og Triggers");
            System.out.println("\nView: (med statement 'select * from KunderMedByNavn')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM KunderMedByNavn");
            ResultSetPrinter.print(resultSet, 20);

            System.out.println("\nStored Procedure: med 'EXEC SamletIndestående 3112692132, @samlet OUTPUT'");
            CallableStatement callableStatement = connection.prepareCall("{call SamletIndestående(?, ?)}");
            callableStatement.setString(1, "3112692132"); // cprNr = 3112692132
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.execute();
            System.out.println("Output: " + callableStatement.getInt(2));

            System.out.println("\nTrigger: med 'INSERT INTO KundeHarKonto (cprNr, regNr, ktoNr) VALUES ('3112692132', 1234, 1234567)'");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO KundeHarKonto VALUES (?,?,?)");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "3112692132");
            preparedStatement.setInt(2, 1234);
            preparedStatement.setLong(3, 1234567);
            preparedStatement.execute();

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
