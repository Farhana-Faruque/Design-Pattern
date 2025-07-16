package com.example.tt.controller;

import com.example.tt.model.Product;
import com.example.tt.util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProductController extends BaseController {
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    @FXML
    private TableColumn<Product, Integer> amountColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField amountField;
    @FXML
    private Label totalAmountLabel;
    @FXML
    private Button addBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button backBtn;

    private ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        loadProducts();
    }

    private void loadProducts() {
        productList.clear();
        String sql = "SELECT id, name, price, amount FROM products";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            double totalAmount = 0.0;
            while (rs.next()) {
                int amount = rs.getInt("amount");
                double price = rs.getDouble("price");
                productList.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        price,
                        amount
                ));
                totalAmount += price * amount;
            }
            productTable.setItems(productList);
            totalAmountLabel.setText(String.format("Total Amount: $%.2f", totalAmount));
        } catch (SQLException e) {
            System.err.println("Error loading products: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to load products: " + e.getMessage());
        }
    }

    @FXML
    private void handleAddProduct() {
        try {
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int amount = Integer.parseInt(amountField.getText().trim());

            if (name.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Name cannot be empty");
                return;
            }
            if (price < 0 || amount < 0) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Price and Amount must be non-negative");
                return;
            }

            if (DatabaseHelper.insertProduct(name, price, amount)) {
                loadProducts();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add product");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Price and Amount must be valid numbers");
        }
    }

    @FXML
    private void handleDeleteProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "No product selected");
            return;
        }

        if (DatabaseHelper.deleteProduct(selectedProduct.getId())) {
            loadProducts();
        } else {
            showAlert(Alert.AlertType.ERROR, "Deletion Error", "Failed to delete product; it may be used in orders");
        }
    }

    @FXML
    private void handleBack() {
        mainApp.showScene("dashboard");
    }

    private void clearFields() {
        nameField.clear();
        priceField.clear();
        amountField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}