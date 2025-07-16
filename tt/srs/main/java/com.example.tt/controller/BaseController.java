package com.example.tt.controller;

import com.example.tt.MainApplication;

public abstract class BaseController {
    protected MainApplication mainApp;

    public void setApplication(MainApplication app) {
        this.mainApp = app;
    }
}
