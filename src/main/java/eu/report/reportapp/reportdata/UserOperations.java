package eu.report.reportapp.reportdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOperations {

    public static void addUser(String userName, String password) {

        String email = "1@2";

        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?,?)";

        Connection connection = DatabaseManager.getConnectToDatabase();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User Added");
            } else {
                System.out.println("User not added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }

    public boolean verifyUser(String username, String password) {

        String sql = "SELECT users.password FROM users where username = ?";
        String userPassword = "";
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

    public void createUser(String userNameInput, String passwordInput) {
        if (userExists(userNameInput)) {
            System.out.println("Can not create, the username is taken");
        } else {
            addUser(userNameInput, passwordInput);
        }

    }

    public boolean userExists(String username) {
        String sql = "SELECT users.username From users where username = ?";
        Connection connection = DatabaseManager.getConnectToDatabase();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }
        return false;
    }

}