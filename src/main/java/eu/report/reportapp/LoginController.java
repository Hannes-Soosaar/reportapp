package eu.report.reportapp;

import eu.report.reportapp.reportdata.UserOperations;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class LoginController {
    @FXML
    private Button registerUserButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;

    public void loginUser() {
        UserOperations userOperations = new UserOperations();
        boolean isActiveUser;
        if (userOperations.verifyUser(userNameField.getText(), passwordField.getText())) isActiveUser = true;
        else isActiveUser = false;

        if (isActiveUser) {
            System.out.println("Is a user");
        } else {
            System.out.println("Not a user");
        }

    }

    public void directToRegisterView(String userNameFiled){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.getRoot());

    }

}