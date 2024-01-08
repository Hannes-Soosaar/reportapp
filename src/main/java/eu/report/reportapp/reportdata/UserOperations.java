package eu.report.reportapp.reportdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOperations {

    public static void addUser(Connection connection, String userName, String email) {

        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, email);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User Added");
            } else {
                System.out.println("User not added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}