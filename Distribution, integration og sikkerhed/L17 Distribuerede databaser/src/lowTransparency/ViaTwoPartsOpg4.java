package lowTransparency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ViaTwoPartsOpg4 {
    public static void main(String[] args) {
        try {
            ArrayList<Person> liste = new ArrayList<>();
            // Læser tabellen personadr via native-driver
            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost;" +
                    "databaseName=ddba;user=sa;password=reallyStrongPwd123;");
            String sql = "SELECT * FROM personadr";
            Statement stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Person p = new Person();
                p.setCpr(res.getString("cpr"));
                p.setNavn(res.getString("navn"));
                p.setBynavn(res.getString("bynavn"));
                liste.add(p);
            }
            // Læser tabellen personloen via native-driver
            Connection minCon2;
            minCon2 = DriverManager.getConnection("jdbc:sqlserver://10.24.2.53;" +
                    "databaseName=ddbb;user=sa;password=mfafoldager17;");
            String sql2 = "SELECT * FROM personloen";
            Statement stmt2 = minCon2.createStatement();
            ResultSet res2 = stmt2.executeQuery(sql2);
            while (res2.next()) {
                for (Person p : liste) {
                    if (p.getCpr().equals(res2.getString("cpr"))) {
                        p.setLoen(res2.getInt("loen"));
                        p.setSkatteprocent(res2.getInt("skatteprocent"));
                    }
                }
            }
            // Udskriver indholdet af de to tabeller
            for (Person s : liste) {
                System.out.print(s.getCpr() + "    ");
                System.out.print(s.getNavn() + "    ");
                System.out.print(s.getBynavn() + "     ");
                System.out.print(s.getLoen() + "     ");
                System.out.println(s.getSkatteprocent());
            }
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}