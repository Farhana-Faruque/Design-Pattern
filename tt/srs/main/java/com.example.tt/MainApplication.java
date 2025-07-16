package com.example.tt;

import com.example.tt.controller.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainApplication extends Application {
    private Stage primaryStage;
    private Map<String, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Desktop Application");

        loadScene("login", "login-view.fxml");
        loadScene("dashboard", "dashboard.fxml");
        loadScene("orderList", "orderList.fxml");
        loadScene("customerList", "customerlist.fxml");
        loadScene("hello", "hello-view.fxml");
        loadScene("productList", "productList.fxml");
        loadScene("addProduct", "addProduct.fxml");

        showScene("hello");
        primaryStage.show();
    }

    private void loadScene(String name, String fxmlFile) throws IOException {
        System.out.println("Loading scene: " + name);
        FXMLLoader floader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(floader.load());
        scenes.put(name, scene);
        System.out.println("Loaded scene: " + name);

        Object controller = floader.getController();
        if (controller instanceof BaseController) {
            ((BaseController) controller).setApplication(this);
        }
    }

    public void showScene(String name) {
        Scene scene = scenes.get(name);
        if (scene != null) {
            primaryStage.setScene(scene);
        } else {
            System.err.println("Scene " + name + " not found!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
