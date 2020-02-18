package andebybank.ex2;

import andebybank.ResultSetPrinter;
import databaseconnection.ConnectionUrl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex2 {

    public static void main(String[] args) {
        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("select regNr, navn, adresse, tlfNr from Afdeling")) {

            ResultSetPrinter.print(resultSet, 20);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
