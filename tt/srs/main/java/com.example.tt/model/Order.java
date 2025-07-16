package com.example.tt.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {
    private final IntegerProperty id;
    private final StringProperty customerName;
    private final StringProperty date;

    public Order(int id, String customerName, String date) {
        this.id = new SimpleIntegerProperty(id);
        this.customerName = new SimpleStringProperty(customerName);
        this.date = new SimpleStringProperty(date);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public StringProperty dateProperty() {
        return date;
    }

    public int getId() {
        return id.get();
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public String getDate() {
        return date.get();
    }
}