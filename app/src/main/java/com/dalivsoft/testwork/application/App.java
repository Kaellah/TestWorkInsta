package com.dalivsoft.testwork.application;

import android.app.Application;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class App extends Application {

    private AppSettings mSettings;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void init() {
        mSettings = AppSettings.getInstance(this);
    }

    public AppSettings getSettings() {
        return mSettings;
    }

}
