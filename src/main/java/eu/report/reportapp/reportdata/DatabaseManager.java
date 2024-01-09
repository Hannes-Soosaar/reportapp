package eu.report.reportapp.reportdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection getConnectToDatabase() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/reportapp_db";
            String user = "postgres";
            String password = getPassword();
            System.out.println(password);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {

        try {
            connection.close();
            System.out.println("connection to DB is closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getPassword(){
        StringBuilder password = new StringBuilder();
        String fileName ="src/main/resources/credentials.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                password.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password.toString();
    }

}
