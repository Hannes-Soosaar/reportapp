package eu.report.reportapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserController {
@FXML
private Button exitButton;

private ViewController viewController = ViewController.getInstance();

public void returnToLoginView(ActionEvent event){
    viewController.startLoginView();
}

}
