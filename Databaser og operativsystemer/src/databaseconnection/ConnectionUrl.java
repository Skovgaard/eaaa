package databaseconnection;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUrl {

    private static String authPath = "src/databaseconnection/auth.xml";

    private static String getUser() throws Exception {
        File file = new File(authPath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        return document.getElementsByTagName("user").item(0).getTextContent();
    }

    private static String getPass() throws Exception {
        File file = new File(authPath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        return document.getElementsByTagName("password").item(0).getTextContent();
    }

    private static String getAddr() throws Exception {
        File file = new File(authPath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        return document.getElementsByTagName("address").item(0).getTextContent();
    }

    public static Connection getConnectionUrl(String database) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://" + getAddr() + ";databaseName=" + database + ";user="
                    + getUser() + ";password=" + getPass());
        } catch (Exception e) {
            System.out.println("Error:  " + e.getMessage());
        }
        return connection;
    }

}
