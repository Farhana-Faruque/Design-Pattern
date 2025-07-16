package com.example.tt.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

    public class Product {
        private final IntegerProperty id;
        private final StringProperty name;
        private final DoubleProperty price;
        private final IntegerProperty amount;

        public Product(int id, String name, double price, int amount) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.price = new SimpleDoubleProperty(price);
            this.amount = new SimpleIntegerProperty(amount);
        }

        public IntegerProperty idProperty() {
            return id;
        }

        public StringProperty nameProperty() {
            return name;
        }

        public DoubleProperty priceProperty() {
            return price;
        }

        public IntegerProperty amountProperty() {
            return amount;
        }

        public int getId() {
            return id.get();
        }

        public String getName() {
            return name.get();
        }

        public double getPrice() {
            return price.get();
        }

        public int getAmount() {
            return amount.get();
        }
    }