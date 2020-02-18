package andebybank.ex7;

import databaseconnection.ConnectionUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ex7 {

    public static void main(String[] args) {

        try (Connection connection = ConnectionUrl.getConnectionUrl("AndebyBank");
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Indtast char");
            String charTest = bufferedReader.readLine();
            System.out.println("Indtast varchar");
            String varCharTest = bufferedReader.readLine();
            System.out.println("Indtast int");
            int intTest = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Indtast decimal");
            double decimalTest = Double.parseDouble(bufferedReader.readLine());
            System.out.println("Indtast dateTime (YYYY-MM-DD HH:MI:SS)");
            String dateTimeTest = bufferedReader.readLine();
            System.out.println("Indtast bit");
            byte bitTest = Byte.parseByte(bufferedReader.readLine());

            String sql = "insert into TestType values (?,?,?,?,?,?)";
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.clearParameters();
            prestmt.setString(1, charTest);
            prestmt.setString(2, varCharTest);
            prestmt.setInt(3, intTest);
            prestmt.setDouble(4, decimalTest);
            prestmt.setString(5, dateTimeTest);
            prestmt.setByte(6, bitTest);
            prestmt.execute();
            System.out.println("TestType er nu tilføjet");

            ResultSet resultSet = statement.executeQuery("select TestType.* from TestType");
            resultSet.last();

            String charTestPrint = resultSet.getString(1);
            String varCharTestPrint = resultSet.getString(2);
            int intTestPrint = resultSet.getInt(3);
            double decimalTestPrint = resultSet.getDouble(4);
            String dateTimeTestPrint = resultSet.getString(5);
            byte bitTestPrint = resultSet.getByte(6);

            System.out.println("\n" + charTestPrint + "    " + varCharTestPrint + "    "
                    + intTestPrint + "    " + decimalTestPrint + "    "
                    + dateTimeTestPrint + "    " + bitTestPrint);


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
