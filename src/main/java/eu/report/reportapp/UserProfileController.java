package eu.report.reportapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserProfileController {
    ViewController viewController = ViewController.getInstance();

    @FXML
    private Button closeProfileViewButton;

    @FXML
    private Label userNameLabel;
    private String activeUser;



    public void setActiveUser(String activeUser){
        this.activeUser = viewController.getUserName();
    }


    public void updateWelcomeText(String activeUser){
        userNameLabel.setText("Welcome " + activeUser );
    }
    public void closeProfile(){
        System.out.println("Close the profile");

    }

}
