package highTransparency;

import lowTransparency.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ViaViewclass {
    public static void main(String[] args) {
        try {
            ArrayList<Person> liste = new ArrayList<>();
            // Læser viewet person via native SQL-Server driver
            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost;" +
                    "databaseName=ddba;user=sa;password=reallyStrongPwd123;");
            String sql = "SELECT * FROM Person";
            Statement stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Person p = new Person();
                p.setCpr(res.getString("cpr"));
                p.setNavn(res.getString("navn"));
                p.setBynavn(res.getString("bynavn"));
                p.setLoen(res.getInt("loen"));
                p.setSkatteprocent(res.getInt("skatteprocent"));
                liste.add(p);
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

