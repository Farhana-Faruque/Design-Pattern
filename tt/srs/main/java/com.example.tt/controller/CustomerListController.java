package com.example.tt.controller;

import com.example.tt.model.Customer;
import com.example.tt.util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class CustomerListController extends BaseController {
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, Integer> idColumn;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;
    @FXML
    private Button addBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private Button backBtn;

    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Set up table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Load data from database
        loadCustomers();
    }

    private void loadCustomers() {
        customerList.clear();
        String sql = "SELECT id, name, email FROM customers";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customerList.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
            customerTable.setItems(customerList);
        } catch (SQLException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }

    @FXML
    private void handleAddCustomer() {
        // Placeholder for adding a customer
        System.out.println("Add Customer button clicked");
    }

    @FXML
    private void handleSearchCustomer() {
        // Placeholder for searching customers
        System.out.println("Search Customer button clicked");
    }

    @FXML
    private void handleBack() {
        mainApp.showScene("dashboard");
    }
}