package com.dalivsoft.testwork.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class AppSettings {

    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    // SINGLETON
    private static AppSettings sInstance;

    // SHARED PREFERENCE`s
    private SharedPreferences mSettings;

    // VALUE`s
    private Context mContext;
    private String mAccessToken;

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
        if (mSettings.contains(ACCESS_TOKEN)) {
            mAccessToken = mSettings.getString(ACCESS_TOKEN, null);
        }
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
        mSettings.edit().putString(ACCESS_TOKEN, mAccessToken);
    }


}
