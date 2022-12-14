package pl.marcinnapierala.passswordManager.controller;

import com.dlsc.formsfx.model.structure.StringField;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.marcinnapierala.passswordManager.user.InternetAccount;

public class AddPassController {

    @FXML
    private TextField domainTextField;

    @FXML
    private PasswordField;

    private MainController parentController;

    public void initialize(MainController parentController) {
        this.parentController = parentController;
    }

    @Override
    public voud mainButtonOnAction() {
        String domain = domainTextField.getText();
        String username = usernameTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();

        if(!password1.equals(password2)) {
            invalidLabel.setText("Passwords do not match");
            invalidLabel.setVisible(true);
        } else {
            InternetAccount newInternetAcccount = new InternetAccount(domain, username, password1);
            parentController.user.addInternetAccount(newInternetAcccount);
            parentController.borderPane.setDisable(false);
            parentController.addPasswordHBox(newInternetAcccount);
            parentController.addPassStage.close();
        }
    }
}
