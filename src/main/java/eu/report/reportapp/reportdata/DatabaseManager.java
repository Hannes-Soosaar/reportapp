package eu.report.reportapp.reportdata;

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
            String password = System.getenv("REPORT_APP_DB_PASSWORD");
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
}
