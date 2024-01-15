package eu.report.reportapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class ReportApplication extends Application {

    @Override
    public void start(Stage stage) {
        ViewController viewController = ViewController.getInstance();
        viewController.setStage(stage);
        viewController.startLoginView();
    }

    public static void main(String[] args) {
        launch();
    }
}