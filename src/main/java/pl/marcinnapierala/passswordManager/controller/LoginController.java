package pl.marcinnapierala.passswordManager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.marcinnapierala.passswordManager.model.Colors;
import pl.marcinnapierala.passswordManager.model.PasswordManagerModel;

import java.io.IOException;

public class LoginController extends SmallWindowsController {
    @FXML
    private Button registerButton;

    @FXML
    BorderPane borderPane;

    PasswordManagerModel model;
    Stage regStage;

    public LoginController() {
        model = new PasswordManagerModel();
        System.out.println("New model created");
    }

    public void mainButtonOnAction() {
        String username = usernameTextField.getText();
        String password = passwordField1.getText();
        if (model.hasUser(username)) && model.isCorrectPassword(username, password)) {
            model.setUser(model.hasUser(username));
            System.out.println("Logged in: " + model.getCurrentUserName());
            openMainWindow();1
        } else {
        invalidLabel.setVisible(true);
        invalidLabel.setText("Invalid login. Please try again.");
        }
    }

    private void openMainWindow() {
        try {
            String viewPath = PasswordManagerModel.VIEW_DIRECTORY + "MainView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            Stage mainStage = new Stage();
            Parent parent = loader.load();
            MainController mainController = loader.getController();
            mainController.initialize(model);
            mainStage.setTitle("Password Manager");
            mainStage.setScene(new Scene(parent));
            mainStage.setResizable(false);
            mainStage.show();
            mainButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerButtonAction() {
        System.out.println("Register new user");
        try {
            String viewPath = PasswordManagerModel.VIEW_DIRECTORY + "RegisterView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            regStage = new Stage();
            Parent parent = loader.load();
            RegisterController registerController = loader.getController();
            registerController.initialize(this);
            regStage.setTitle("Register");
            regStage.setScene(new Scene(parent));
            regStage.setResizable(false);
            regStage.show();
            borderPane.setDisable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerButtonOnEnter () {
        registerButton.setStyle(Colors.setBackgroundColor(Colors.LIGHT_Grey));
    }
    public void registerButtonOnExit () {
        registerButton.setStyle(Colors.setBackgroundColor(Colors.MAIN_BLUE));
    }

}
