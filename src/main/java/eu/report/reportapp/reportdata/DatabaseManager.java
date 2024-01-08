package eu.report.reportapp.reportdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static void connectToDatabase(){

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/reportapp_db";
            String user = "postgres";
            String password = "hannes123";
            connection = DriverManager.getConnection(url, user, password);

            UserOperations.addUser(connection, "hannes","hannes@gmail.com");

            //call oppertaions with DB here!

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) ;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
