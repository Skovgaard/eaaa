package andebybank.ex3;

import databaseconnection.ConnectionUrl;
import resultsetprinter.ResultSetPrinter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex3 {

    public static void main(String[] args) {
        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("select regNr, navn, adresse, tlfNr from Afdeling")) {

            System.out.println("Table:");
            ResultSetPrinter.print(resultSet, 20);

            //previous
            System.out.println("\nPrevious:");
            resultSet.previous();
            System.out.println(resultSet.getInt(1) + "    " + resultSet.getString(2) + "    " + resultSet.getString(3) + "    " + resultSet.getString(4));

            //absolute
            System.out.println("\nAbsolute(2)");
            resultSet.absolute(2);
            System.out.println(resultSet.getInt(1) + "    " + resultSet.getString(2) + "    " + resultSet.getString(3) + "    " + resultSet.getString(4));

            System.out.println(Integer.MAX_VALUE);
            //relative
            System.out.println("\nRelative(-1)");
            resultSet.relative(-1);
            System.out.println(resultSet.getInt(1) + "    " + resultSet.getString(2) + "    " + resultSet.getString(3) + "    " + resultSet.getString(4));

            //first
            System.out.println("\nFirst");
            resultSet.first();
            System.out.println(resultSet.getInt(1) + "    " + resultSet.getString(2) + "    " + resultSet.getString(3) + "    " + resultSet.getString(4));

            //last
            System.out.println("\nLast");
            resultSet.last();
            System.out.println(resultSet.getInt(1) + "    " + resultSet.getString(2) + "    " + resultSet.getString(3) + "    " + resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
