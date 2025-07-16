package com.example.tt.controller;

import com.example.tt.model.Order;
import com.example.tt.util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class OrderListController extends BaseController {
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, Integer> idColumn;
    @FXML
    private TableColumn<Order, String> customerNameColumn;
    @FXML
    private TableColumn<Order, String> dateColumn;
    @FXML
    private Button backBtn;

    private ObservableList<Order> orderList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Set up table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Load data from database
        loadOrders();
    }

    private void loadOrders() {
        orderList.clear();
        String sql = "SELECT o.id, c.name AS customer_name, o.date " +
                "FROM orders o " +
                "JOIN customers c ON o.customer_id = c.id";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orderList.add(new Order(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getString("date")
                ));
            }
            orderTable.setItems(orderList);
        } catch (SQLException e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }
    }

    @FXML
    private void handleBack() {
        mainApp.showScene("dashboard");
    }
}