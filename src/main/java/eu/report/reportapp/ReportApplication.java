package eu.report.reportapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ReportApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ReportApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        ViewController viewController = new ViewController();
        viewController.setStage(stage);
        LoginController loginController = fxmlLoader.getController();
        loginController.setViewController(viewController);
        stage.setTitle("Report App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}