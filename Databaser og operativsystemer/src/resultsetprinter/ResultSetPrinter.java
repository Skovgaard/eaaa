package resultsetprinter;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetPrinter {

    public static void print(ResultSet resultSet, int spacing) {
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (i != columnCount)
                    System.out.printf("%" + -spacing + "s", resultSetMetaData.getColumnName(i).trim());
                else
                    System.out.printf("%s%n", resultSetMetaData.getColumnName(i).trim());
            }
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i != columnCount)
                        System.out.printf("%" + -spacing + "s", resultSet.getString(i).trim());
                    else
                        System.out.printf("%s%n", resultSet.getString(i).trim());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
