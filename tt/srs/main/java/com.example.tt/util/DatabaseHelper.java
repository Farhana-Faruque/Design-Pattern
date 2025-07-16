package com.example.tt.util;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:pos.db";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            // Attempt to create the database file if it doesn't exist
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:")) {
                System.out.println("Created new database file: pos.db");
            } catch (SQLException ex) {
                System.err.println("Failed to create database: " + ex.getMessage());
            }
            throw e; // Re-throw the original exception
        }
    }

    public static boolean insertUser(String email, String hashedPassword, String name) {
        String sql = "INSERT INTO users (name, email, type, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, "employee");
            stmt.setString(4, hashedPassword);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Registration error: " + e.getMessage());
            return false;
        }
    }

    public static boolean verifyUser(String email, String plainPassword) {
        String sql = "SELECT password FROM users WHERE email = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("password");
                return BCrypt.checkpw(plainPassword, storedHash);
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public static boolean insertProduct(String name, double price, int amount) {
        String sql = "INSERT INTO products (name, price, amount) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, amount);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteProduct(int id) {
        String checkSql = "SELECT COUNT(*) FROM order_items WHERE product_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(checkSql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.err.println("Cannot delete product: it is referenced in order_items");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error checking product references: " + e.getMessage());
            return false;
        }

        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            return false;
        }
    }
}
