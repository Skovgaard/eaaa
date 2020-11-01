package opg16og17og18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class testsql {

    public static void main(String[] args) {
        try {
            System.out.println("Program startet");
            Connection connection;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;" +
                    "databaseName=bankdb;user=sa;password=reallyStrongPwd123;");

            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("select * from konto");
            System.out.println("----------");
            System.out.println("Database status:");
            while (res.next()) {
                System.out.println("Konto " + res.getInt(1) + " har saldo " + res.getInt(2) + " og ejer " + res.getString(3));
            }
            System.out.println("----------");

            /*
            Indlæs frakonto fra bruger
            Indlæs tilkonto fra bruger
            Indlæs beløb fra bruger
            Check at frakonto eksisterer og find saldoen
            Kontroller at saldo er større end det beløb, der ønskes overført
            Check at tilkonto eksisterer og find saldoen
            Beregn de nye saldi
            Opdater frakonto med den nye saldo
            Opdater tilkonto med den nye saldo
             */

//            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ); // OPGAVE 17
//            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // OPGAVE 17

            connection.setAutoCommit(false); // OPGAVE 16

            Scanner scanner = new Scanner(System.in);
            // Indlæs frakonto fra bruger
            System.out.println("Indtast frakonto");
            int frakonto = Integer.parseInt(scanner.nextLine());
            // Indlæs tilkonto fra bruger
            System.out.println("Indtast tilkonto");
            int tilkonto = Integer.parseInt(scanner.nextLine());
            // Indlæs beløb fra bruger
            System.out.println("Indtast beløb");
            int beløb = Integer.parseInt(scanner.nextLine());
            System.out.println("Frakonto: " + frakonto + " tilkonto: " + tilkonto + " beløb: " + beløb);

            // Check at frakonto eksisterer og find saldoen
            int frakontoSaldo;
            res = stmt.executeQuery("select * from konto (UPDLOCK) where kontonr=" + frakonto); // OPGAVE 18
            if (res.next()) {
                int kontonr = res.getInt(1);
                frakontoSaldo = res.getInt(2);
                String ejer = res.getString(3);
                System.out.println("Konto " + kontonr + " har saldo " + frakontoSaldo + " og ejer " + ejer);
            } else
                throw new Exception("Fra konto eksisterer ikke");

            // Kontroller at saldo er større end det beløb, der ønskes overført
            System.out.println("Saldo: " + frakontoSaldo + " ønsket overførsel: " + beløb);
            if (frakontoSaldo < beløb)
                throw new Exception("Beløb større end saldo");

            // Check at tilkonto eksisterer og find saldoen
            int tilkontoSaldo;
            res = stmt.executeQuery("select * from konto (UPDLOCK) where kontonr=" + tilkonto); // OPGAVE 18
            if (res.next()) {
                int kontonr = res.getInt(1);
                tilkontoSaldo = res.getInt(2);
                String ejer = res.getString(3);
                System.out.println("Konto " + kontonr + " har saldo " + frakontoSaldo + " og ejer " + ejer);
            } else
                throw new Exception("til konto eksisterer ikke");

            // Beregn de nye saldi
            int frakontoNySaldi = frakontoSaldo - beløb;
            System.out.println("Ny frakonto saldo: " + frakontoNySaldi);
            int tilkontoNySaldi = tilkontoSaldo + beløb;
            System.out.println("Ny tilkonto saldo: " + tilkontoNySaldi);

            System.out.println("Venter her"); // VENTER HER
            scanner.nextLine();

            // Opdater frakonto med den nye saldo
            stmt.executeUpdate("update konto set saldo=" + frakontoNySaldi + " where kontonr=" + frakonto);

            // Opdater tilkonto med den nye saldo
            stmt.executeUpdate("update konto set saldo=" + tilkontoNySaldi + " where kontonr=" + tilkonto);

            connection.commit(); // OPGAVE 16

            res = stmt.executeQuery("select * from konto");
            System.out.println("----------");
            System.out.println("Database status:");
            while (res.next()) {
                System.out.println("Konto " + res.getInt(1) + " har saldo " + res.getInt(2) + " og ejer " + res.getString(3));
            }
            System.out.println("----------");

            if (stmt != null)
                stmt.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            System.out.print("fejl:  " + e.getMessage());
        }
    }
}