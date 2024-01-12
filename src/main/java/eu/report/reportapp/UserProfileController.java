package eu.report.reportapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserProfileController {

    private ViewController viewController =ViewController.getInstance();
    @FXML
    private Button closeProfileViewButton;

    @FXML
    private Label userNameLable;
    private String activeUser;

    public void setActiveUser(String activeUser){
        this.activeUser = activeUser;
    }

    public void updateWelcomeText(String activeUser){
        userNameLable.setText("Welcome " + activeUser );
    }
    public void closeProfile(){
        System.out.println("Close the profile");

    }

}
