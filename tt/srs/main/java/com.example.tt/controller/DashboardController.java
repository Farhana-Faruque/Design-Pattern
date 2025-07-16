package com.example.tt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardController extends BaseController {
    @FXML
    private Button orderListBtn;
    @FXML
    private Button customerListBtn;
    @FXML
    private Button productListBtn;
    @FXML
    private Button addProductBtn;
    @FXML
    private Button logoutBtn;

    @FXML
    private void handleOrderList() {
        mainApp.showScene("orderList");
    }

    @FXML
    private void handleCustomerList() {
        mainApp.showScene("customerList");
    }

    @FXML
    private void handleProductList() {
        mainApp.showScene("productList");
    }

    @FXML
    private void handleAddProduct() {
        mainApp.showScene("addProduct");
    }

    @FXML
    private void handleLogout() {
        mainApp.showScene("login");
    }
}
