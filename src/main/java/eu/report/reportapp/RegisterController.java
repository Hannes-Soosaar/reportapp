package eu.report.reportapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class RegisterController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button createUserButton;

    private ViewController viewController;

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void returnToLoginView(ActionEvent event) {
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        viewController.startLoginView(scene.getWindow());
    }

    public void createUser() {

    }


}
