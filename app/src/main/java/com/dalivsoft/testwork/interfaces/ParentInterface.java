package com.dalivsoft.testwork.interfaces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;

import com.dalivsoft.testwork.application.App;
import com.dalivsoft.testwork.application.AppSettings;
import com.octo.android.robospice.request.SpiceRequest;
import com.octo.android.robospice.request.listener.RequestListener;

public interface ParentInterface {

    IntentFilter getIntentFilter();

    void onBroadcastReceive(Context context, Intent intent);

    /**
     * Add to back stack by default
     */
    void startFragment(Fragment fragment);

    void startFragment(Fragment fragment, boolean addToBackStack);

    void setBlocking(boolean block);

    App getApp();

    AppSettings getSettings();

    Activity getActivity();

    boolean execute(SpiceRequest request, RequestListener listener);
}