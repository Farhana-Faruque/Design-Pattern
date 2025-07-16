package com.example.tt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController extends BaseController {
    @FXML
    private Button logInButton;

    @FXML
    private void handleLogIn() {
        mainApp.showScene("login");
    }
}