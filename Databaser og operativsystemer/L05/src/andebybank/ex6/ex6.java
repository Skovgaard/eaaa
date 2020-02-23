package andebybank.ex6;

import databaseconnection.ConnectionUrl;
import resultsetprinter.ResultSetPrinter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ex6 {

    public static void main(String[] args) {

        ArrayList<Transaktion> transaktioner = new ArrayList<>();

        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("select Transaktion.* from Transaktion where Transaktion.ktoNr = '1357967'")) {

            while (resultSet.next()) {
                int regNr = resultSet.getInt(1);
                long ktoNr = resultSet.getLong(2);
                String dato = resultSet.getString(3);
                String tekst = resultSet.getString(4).trim();
                double beløb = resultSet.getDouble(5);
                transaktioner.add(new Transaktion(regNr, ktoNr, dato, tekst, beløb));
            }

            resultSet.first();
            ResultSetPrinter.print(resultSet, 15);

//            for (Transaktion t : transaktioner) {
//                System.out.println(t);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
