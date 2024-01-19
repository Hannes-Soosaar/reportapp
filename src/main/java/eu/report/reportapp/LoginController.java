package eu.report.reportapp;

import eu.report.reportapp.reportdata.UserOperations;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button registerUserButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    private  ViewController viewController = ViewController.getInstance();

    public String getUserNameFiled(){
        return  this.userNameField.getText();
    }

    public void loginUser() {
        UserOperations userOperations = new UserOperations();
        boolean isActiveUser; // todo check if user is active and what their accessLevel is

        if (userOperations.verifyUser(userNameField.getText(), passwordField.getText())) isActiveUser = true;
        else isActiveUser = false;
        if (isActiveUser) { //
            viewController.setUserName(userNameField.getText());
            viewController.startUserView();

        } else {
            System.out.println("Not a user");
        }
    }

    public void directToRegisterView() {
        ViewController viewController = ViewController.getInstance();
        viewController.startRegisterView();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

            }
        });
    }

}