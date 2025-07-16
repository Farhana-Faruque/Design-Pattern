package com.example.tt.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty email;

    public Customer(int id, String name, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getEmail() {
        return email.get();
    }
}
