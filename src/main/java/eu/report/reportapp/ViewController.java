package eu.report.reportapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

/*
 the ViewController is setup to only have one instance that takes care of sharing the stage and reloading scenes

*/


public class ViewController {
    private static ViewController instance;
    private String userName;

    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
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

    public void startLoginView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 640, 400);
            Stage currentStage = getStage();
            if (currentStage != null) {
                currentStage.setScene(scene);
                currentStage.setTitle("Report app");
                currentStage.show();
            } else {
                throw new IllegalStateException("Stage Reference is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startUserView() {
        String activeUser = getUserName();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 760, 540);
            Stage currentStage = getStage();
            if (currentStage != null) {
                currentStage.setScene(scene);
                currentStage.setTitle("Welcome " + activeUser + " to report app!");
                currentStage.show();
            } else {
                throw new IllegalStateException("Stage reference is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Login completed for" + activeUser);
        }

    }

    public void startUserProfileView() {
//        UserController userController = new UserController();
        UserProfileController userProfileController = new UserProfileController();
        String activeUser = getUserName();
        userProfileController.setActiveUser(activeUser);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user-settings-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 760, 540);
            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("User Details for " + activeUser);
            popStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("your are change" + activeUser);
            userProfileController.setActiveUser(activeUser);
            userProfileController.updateWelcomeText(activeUser);
        }

    }

}
