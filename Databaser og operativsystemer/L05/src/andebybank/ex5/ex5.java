package andebybank.ex5;

import databaseconnection.ConnectionUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ex5 {

    public static void main(String[] args) {

        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Indtast cprNr");
            String cprNr = bufferedReader.readLine();
            System.out.println("Indtast afdeling");
            int afdeling = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Indtast titel");
            String titel = bufferedReader.readLine();
            System.out.println("Indtast navn");
            String navn = bufferedReader.readLine();
            System.out.println("Indtast adresse");
            String adresse = bufferedReader.readLine();
            System.out.println("Indtast postNr");
            int postNr = Integer.parseInt(bufferedReader.readLine());

            String sql = "insert into Medarbejder values (?,?,?,?,?,?)";
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.clearParameters();
            prestmt.setString(1, cprNr);
            prestmt.setInt(2, afdeling);
            prestmt.setString(3, titel);
            prestmt.setString(4, navn);
            prestmt.setString(5, adresse);
            prestmt.setInt(6, postNr);
            prestmt.execute();
            System.out.println("Medarbejder er nu oprettet");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
