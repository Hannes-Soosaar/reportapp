package eu.report.reportapp;

import eu.report.reportapp.reportdata.UserOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button createUserButton;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passwordField;

    public void returnToLoginView(ActionEvent event) {
        ViewController viewController = ViewController.getInstance();
        viewController.startLoginView();
    }

    public void createUser(ActionEvent event) {
        UserOperations userOperations = new UserOperations();
        userOperations.createUser(userName.getText(), passwordField.getText());
    }


}
