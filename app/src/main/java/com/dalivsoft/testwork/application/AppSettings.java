package com.dalivsoft.testwork.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class AppSettings {


    // SINGLETON
    private static AppSettings sInstance;

    // SHARED PREFERENCE`s
    private SharedPreferences mSettings;

    // VALUE`s
    private Context mContext;

    private AppSettings(Context context) {
        mSettings = PreferenceManager.getDefaultSharedPreferences(context);
        mContext = context;
        loadSettings();
    }

    public static AppSettings getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AppSettings.class) {
                if (sInstance == null) {
                    sInstance = new AppSettings(context);
                }
            }
        }
        return sInstance;
    }

    protected void loadSettings() {

    }
}
