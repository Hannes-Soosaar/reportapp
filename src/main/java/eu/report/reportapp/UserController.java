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


public void setActiveUser(String activeUser){ // todo there is an issue here with creating instances again.
    this.activeUser=activeUser;
}
private ViewController viewController = ViewController.getInstance();

public void returnToLoginView(ActionEvent event){
    viewController.startLoginView();
}

public void updateProfile(){
    viewController.startUserProfileView();
    //todo make a site where you can change your details
    // should be a pop-up window.
}

}
