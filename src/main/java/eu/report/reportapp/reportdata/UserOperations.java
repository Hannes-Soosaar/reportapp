package eu.report.reportapp.reportdata;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOperations {

    public static void addUser(String userName, String email) {

        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";

        Connection connection = DatabaseManager.getConnectToDatabase();

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
        DatabaseManager.closeConnection(connection);
    }

    public boolean verifyUser(String username, String password) {

        String sql = "SELECT users.password FROM users where username = ?";
        String userPassword = "";
        System.out.println(sql);
        Connection connection = DatabaseManager.getConnectToDatabase();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userPassword = resultSet.getString("password");
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.closeConnection(connection);
        return userPassword.equals(password);

    }
}