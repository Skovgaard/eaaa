package opg19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class testsqlOptimistisk {

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

            // Kan også bruge anden lock før begin transaction
            // Kan bruge row version til at sammenligne

            Scanner scanner = new Scanner(System.in);
            // Indlæs et kontonummer fra bruger
            System.out.println("Indtast kontonummer");
            int kontonummer = Integer.parseInt(scanner.nextLine());

            // Vis alle oplysninger om den pågældende konto
            res = stmt.executeQuery("select * from konto where kontonr=" + kontonummer);
            int saldo;
            String ejer;
            if (res.next()) {
//                kontonummer = res.getInt(1);
                saldo = res.getInt(2);
                ejer = res.getString(3);
                System.out.println("Konto " + kontonummer + " har saldo " + saldo + " og ejer " + ejer);
            } else
                throw new Exception("Fra konto eksisterer ikke");

            // Indlæs en ny saldo fra bruger
            System.out.println("Indtast ny saldo");
            int nySaldo = Integer.parseInt(scanner.nextLine());

            connection.setAutoCommit(false);

            res = stmt.executeQuery("select * from konto (UPDLOCK) where kontonr=" + kontonummer);
            if (res.next()) {
                if (kontonummer == res.getInt(1) && saldo == res.getInt(2) && ejer.equals(res.getString(3))){
                    // Opdater saldo på den pågældende konto til den værdi brugeren har indtastet
                    stmt.executeUpdate("update konto set saldo=" + nySaldo + " where kontonr=" + kontonummer);
                    connection.commit();
                } else {
                    System.out.println("Øøøøøøv kunne ikke gennemføres");
                    connection.rollback();
                }
            }

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