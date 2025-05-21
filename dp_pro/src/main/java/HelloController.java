package com.example.dp_pro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField NameField;

    @FXML
    private TextField EmailField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    protected void onLogInButtonClick() {
        String name = NameField.getText();
        String email = EmailField.getText();
        String password = PasswordField.getText();

        // For demonstration
        welcomeText.setText("Welcome, " + name + "!");
    }
}
