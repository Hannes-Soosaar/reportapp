package eu.report.reportapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ViewController {

    private Stage stage;

    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Stage getStage(){
        return this.stage;
    }


    public void startRegisterView() {
        try {
            String REGISTER_VIEW = "register-view.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(REGISTER_VIEW));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 640, 400);
            Stage currentStage = getStage();
            if (currentStage != null) {
                currentStage.setScene(scene);
                currentStage.setTitle("Register a new user");
                currentStage.show();
            } else {
                throw new IllegalStateException("Stage reference is null.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void startLoginView(Window window){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 640,400);
            Stage currentStage = getStage();
            if (currentStage !=null){
                currentStage.setScene(scene);
                currentStage.setTitle("Report app");
                currentStage.show();
            } else {
                throw new IllegalStateException("Stage Reference is null");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
