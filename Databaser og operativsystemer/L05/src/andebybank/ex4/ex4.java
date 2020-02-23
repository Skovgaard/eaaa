package andebybank.ex4;

import databaseconnection.ConnectionUrl;
import resultsetprinter.ResultSetPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex4 {

    public static void main(String[] args) {

        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Indtast kundeId");
            String input = bufferedReader.readLine();

            ResultSet resultSet = statement.executeQuery("SELECT Konto.*\n" +
                    "FROM Konto \n" +
                    "INNER JOIN KundeHarKonto on Konto.ktoNr = KundeHarKonto.ktonr \n" +
                    "where KundeHarKonto.cprNr='" + input + "'");

            ResultSetPrinter.print(resultSet, 15);

            resultSet.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
