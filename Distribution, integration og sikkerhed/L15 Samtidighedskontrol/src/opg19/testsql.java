package opg19;

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
            ResultSet res = stmt.executeQuery("SELECT * FROM konto");
            System.out.println("----------");
            System.out.println("Database status:");
            while (res.next()) {
                System.out.println("Konto " + res.getInt(1) + " har saldo " + res.getInt(2) + " og ejer " + res.getString(3));
            }
            System.out.println("----------");

            /*
            • Indlæs et kontonummer fra bruger
            • Vis alle oplysninger om den pågældende konto
            • Indlæs en ny saldo fra bruger
            • Opdater saldo på den pågældende konto til den værdi brugeren har indtastet
             */

            connection.setAutoCommit(false);

            Scanner scanner = new Scanner(System.in);
            // Indlæs et kontonummer fra bruger
            System.out.println("Indtast kontonummer");
            int kontonummer = Integer.parseInt(scanner.nextLine());

            // Vis alle oplysninger om den pågældende konto
            res = stmt.executeQuery("select * from konto where kontonr=" + kontonummer);
            if (res.next()) {
                int kontonr = res.getInt(1);
//                kontonummer = res.getInt(2);
                String ejer = res.getString(3);
                System.out.println("Konto " + kontonr + " har saldo " + kontonummer + " og ejer " + ejer);
            } else
                throw new Exception("Fra konto eksisterer ikke");

            // Indlæs en ny saldo fra bruger
            System.out.println("Indtast ny saldo");
            int saldo = Integer.parseInt(scanner.nextLine());


            // Opdater saldo på den pågældende konto til den værdi brugeren har indtastet
            stmt.executeUpdate("update konto set saldo=" + saldo + " where kontonr=" + kontonummer);

            connection.commit();

            res = stmt.executeQuery("SELECT * FROM konto");
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