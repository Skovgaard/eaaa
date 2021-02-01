import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;

public class minklasse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            System.out.println("Indtast brugernavn");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            String s1 = inLine.readLine();
            System.out.println("Indtast password");
            String s2 = inLine.readLine();
            Connection minConnection;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost;" +
                    "databaseName=tempdb;user=sa;password=reallyStrongPwd123;");
            Statement stmt = minConnection.createStatement();
            String s = "select * from brugere where brugerid = '" + s1 +
                    "' and passw = '" + s2 + "'";
            System.out.println(s);
            ResultSet res = stmt.executeQuery(s);
            if (res.next()) {
                System.out.print("Velkommen du er nu logget ind");
            } else
                System.out.print("Ukorrekt logon");

            if (stmt != null)
                stmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.print("fejl:  " + e.getMessage());
        }

    }

}