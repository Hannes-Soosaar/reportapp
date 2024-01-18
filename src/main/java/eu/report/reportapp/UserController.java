package eu.report.reportapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserController {
@FXML
private Button exitButton;
@FXML
private Button userProfile;

private String activeUser;

public void setActiveUser(String activeUser){
    this.activeUser=activeUser;
}

private ViewController viewController = ViewController.getInstance();

public void returnToLoginView(ActionEvent event){
    viewController.startLoginView();
}

public void updateProfile(){
    viewController.startUserProfileView(activeUser);
}

}
